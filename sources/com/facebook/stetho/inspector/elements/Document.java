package com.facebook.stetho.inspector.elements;

import android.os.SystemClock;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.ShadowDocument;
import com.facebook.stetho.inspector.helper.ObjectIdMapper;
import com.facebook.stetho.inspector.helper.ThreadBoundProxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
public final class Document extends ThreadBoundProxy {
    private AttributeListAccumulator mCachedAttributeAccumulator;
    private ChildEventingList mCachedChildEventingList;
    private ArrayListAccumulator<Object> mCachedChildrenAccumulator;
    private final Queue<Object> mCachedUpdateQueue;
    private DocumentProvider mDocumentProvider;
    private final DocumentProviderFactory mFactory;
    private final ObjectIdMapper mObjectIdMapper;
    private int mReferenceCounter;
    private ShadowDocument mShadowDocument;
    private UpdateListenerCollection mUpdateListeners;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class AttributeListAccumulator extends ArrayList<String> implements AttributeAccumulator {
        @Override // com.facebook.stetho.inspector.elements.AttributeAccumulator
        public void store(String str, String str2) {
            add(str);
            add(str2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ChildEventingList extends ArrayList<Object> {
        private DocumentView mDocumentView;
        private Object mParentElement;
        private int mParentNodeId;

        private ChildEventingList() {
            this.mParentElement = null;
            this.mParentNodeId = -1;
        }

        public void acquire(Object obj, DocumentView documentView) {
            this.mParentElement = obj;
            this.mParentNodeId = obj == null ? -1 : Document.this.mObjectIdMapper.getIdForObject(this.mParentElement).intValue();
            this.mDocumentView = documentView;
        }

        public void addWithEvent(int i3, Object obj, Accumulator<Object> accumulator) {
            Object obj2 = i3 == 0 ? null : get(i3 - 1);
            int iIntValue = obj2 == null ? -1 : Document.this.mObjectIdMapper.getIdForObject(obj2).intValue();
            add(i3, obj);
            Document.this.mUpdateListeners.onChildNodeInserted(this.mDocumentView, obj, this.mParentNodeId, iIntValue, accumulator);
        }

        public void release() {
            clear();
            this.mParentElement = null;
            this.mParentNodeId = -1;
            this.mDocumentView = null;
        }

        public void removeWithEvent(int i3) {
            Document.this.mUpdateListeners.onChildNodeRemoved(this.mParentNodeId, Document.this.mObjectIdMapper.getIdForObject(remove(i3)).intValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class DocumentObjectIdMapper extends ObjectIdMapper {
        private DocumentObjectIdMapper() {
        }

        @Override // com.facebook.stetho.inspector.helper.ObjectIdMapper
        protected void onMapped(Object obj, int i3) {
            Document.this.verifyThreadAccess();
            Document.this.mDocumentProvider.getNodeDescriptor(obj).hook(obj);
        }

        @Override // com.facebook.stetho.inspector.helper.ObjectIdMapper
        protected void onUnmapped(Object obj, int i3) {
            Document.this.verifyThreadAccess();
            Document.this.mDocumentProvider.getNodeDescriptor(obj).unhook(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class ProviderListener implements DocumentProviderListener {
        private ProviderListener() {
        }

        @Override // com.facebook.stetho.inspector.elements.DocumentProviderListener
        public void onAttributeModified(Object obj, String str, String str2) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onAttributeModified(obj, str, str2);
        }

        @Override // com.facebook.stetho.inspector.elements.DocumentProviderListener
        public void onAttributeRemoved(Object obj, String str) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onAttributeRemoved(obj, str);
        }

        @Override // com.facebook.stetho.inspector.elements.DocumentProviderListener
        public void onInspectRequested(Object obj) {
            Document.this.verifyThreadAccess();
            Document.this.mUpdateListeners.onInspectRequested(obj);
        }

        @Override // com.facebook.stetho.inspector.elements.DocumentProviderListener
        public void onPossiblyChanged() {
            Document.this.updateTree();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface UpdateListener {
        void onAttributeModified(Object obj, String str, String str2);

        void onAttributeRemoved(Object obj, String str);

        void onChildNodeInserted(DocumentView documentView, Object obj, int i3, int i4, Accumulator<Object> accumulator);

        void onChildNodeRemoved(int i3, int i4);

        void onInspectRequested(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class UpdateListenerCollection implements UpdateListener {
        private final List<UpdateListener> mListeners = new ArrayList();
        private volatile UpdateListener[] mListenersSnapshot;

        public UpdateListenerCollection() {
        }

        private UpdateListener[] getListenersSnapshot() {
            while (true) {
                UpdateListener[] updateListenerArr = this.mListenersSnapshot;
                if (updateListenerArr != null) {
                    return updateListenerArr;
                }
                synchronized (this) {
                    try {
                        if (this.mListenersSnapshot == null) {
                            List<UpdateListener> list = this.mListeners;
                            this.mListenersSnapshot = (UpdateListener[]) list.toArray(new UpdateListener[list.size()]);
                            return this.mListenersSnapshot;
                        }
                    } finally {
                    }
                }
            }
        }

        public synchronized void add(UpdateListener updateListener) {
            this.mListeners.add(updateListener);
            this.mListenersSnapshot = null;
        }

        public synchronized void clear() {
            this.mListeners.clear();
            this.mListenersSnapshot = null;
        }

        @Override // com.facebook.stetho.inspector.elements.Document.UpdateListener
        public void onAttributeModified(Object obj, String str, String str2) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onAttributeModified(obj, str, str2);
            }
        }

        @Override // com.facebook.stetho.inspector.elements.Document.UpdateListener
        public void onAttributeRemoved(Object obj, String str) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onAttributeRemoved(obj, str);
            }
        }

        @Override // com.facebook.stetho.inspector.elements.Document.UpdateListener
        public void onChildNodeInserted(DocumentView documentView, Object obj, int i3, int i4, Accumulator<Object> accumulator) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onChildNodeInserted(documentView, obj, i3, i4, accumulator);
            }
        }

        @Override // com.facebook.stetho.inspector.elements.Document.UpdateListener
        public void onChildNodeRemoved(int i3, int i4) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onChildNodeRemoved(i3, i4);
            }
        }

        @Override // com.facebook.stetho.inspector.elements.Document.UpdateListener
        public void onInspectRequested(Object obj) {
            for (UpdateListener updateListener : getListenersSnapshot()) {
                updateListener.onInspectRequested(obj);
            }
        }

        public synchronized void remove(UpdateListener updateListener) {
            this.mListeners.remove(updateListener);
            this.mListenersSnapshot = null;
        }
    }

    public Document(DocumentProviderFactory documentProviderFactory) {
        super(documentProviderFactory);
        this.mFactory = documentProviderFactory;
        this.mObjectIdMapper = new DocumentObjectIdMapper();
        this.mReferenceCounter = 0;
        this.mUpdateListeners = new UpdateListenerCollection();
        this.mCachedUpdateQueue = new ArrayDeque();
    }

    private AttributeListAccumulator acquireCachedAttributeAccumulator() {
        AttributeListAccumulator attributeListAccumulator = this.mCachedAttributeAccumulator;
        if (attributeListAccumulator == null) {
            attributeListAccumulator = new AttributeListAccumulator();
        }
        this.mCachedChildrenAccumulator = null;
        return attributeListAccumulator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChildEventingList acquireChildEventingList(Object obj, DocumentView documentView) {
        ChildEventingList childEventingList = this.mCachedChildEventingList;
        if (childEventingList == null) {
            childEventingList = new ChildEventingList();
        }
        this.mCachedChildEventingList = null;
        childEventingList.acquire(obj, documentView);
        return childEventingList;
    }

    private ArrayListAccumulator<Object> acquireChildrenAccumulator() {
        ArrayListAccumulator<Object> arrayListAccumulator = this.mCachedChildrenAccumulator;
        if (arrayListAccumulator == null) {
            arrayListAccumulator = new ArrayListAccumulator<>();
        }
        this.mCachedChildrenAccumulator = null;
        return arrayListAccumulator;
    }

    private void applyDocumentUpdate(final ShadowDocument.Update update) {
        final ArrayList arrayList = new ArrayList();
        update.getGarbageElements(new Accumulator<Object>() { // from class: com.facebook.stetho.inspector.elements.Document.3
            @Override // com.facebook.stetho.common.Accumulator
            public void store(Object obj) {
                Integer num = (Integer) Util.throwIfNull(Document.this.mObjectIdMapper.getIdForObject(obj));
                if (update.getElementInfo(obj).parentElement == null) {
                    Document.this.mUpdateListeners.onChildNodeRemoved(Document.this.mObjectIdMapper.getIdForObject(Document.this.mShadowDocument.getElementInfo(obj).parentElement).intValue(), num.intValue());
                }
                arrayList.add(num);
            }
        });
        Collections.sort(arrayList);
        update.getChangedElements(new Accumulator<Object>() { // from class: com.facebook.stetho.inspector.elements.Document.4
            @Override // com.facebook.stetho.common.Accumulator
            public void store(Object obj) {
                ElementInfo elementInfo;
                Integer num = (Integer) Util.throwIfNull(Document.this.mObjectIdMapper.getIdForObject(obj));
                if (Collections.binarySearch(arrayList, num) >= 0 || (elementInfo = Document.this.mShadowDocument.getElementInfo(obj)) == null || update.getElementInfo(obj).parentElement == elementInfo.parentElement) {
                    return;
                }
                Document.this.mUpdateListeners.onChildNodeRemoved(Document.this.mObjectIdMapper.getIdForObject(elementInfo.parentElement).intValue(), num.intValue());
            }
        });
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.mObjectIdMapper.removeObjectById(((Integer) arrayList.get(i3)).intValue());
        }
        update.getChangedElements(new Accumulator<Object>() { // from class: com.facebook.stetho.inspector.elements.Document.5
            private final HashSet<Object> listenerInsertedElements = new HashSet<>();
            private Accumulator<Object> insertedElements = new Accumulator<Object>() { // from class: com.facebook.stetho.inspector.elements.Document.5.1
                @Override // com.facebook.stetho.common.Accumulator
                public void store(Object obj) {
                    if (update.isElementChanged(obj)) {
                        AnonymousClass5.this.listenerInsertedElements.add(obj);
                    }
                }
            };

            @Override // com.facebook.stetho.common.Accumulator
            public void store(Object obj) {
                ElementInfo elementInfo;
                if (Document.this.mObjectIdMapper.containsObject(obj) && !this.listenerInsertedElements.contains(obj)) {
                    ElementInfo elementInfo2 = Document.this.mShadowDocument.getElementInfo(obj);
                    ElementInfo elementInfo3 = update.getElementInfo(obj);
                    List<Object> list = elementInfo2 != null ? elementInfo2.children : Collections.EMPTY_LIST;
                    List<Object> list2 = elementInfo3.children;
                    ChildEventingList childEventingListAcquireChildEventingList = Document.this.acquireChildEventingList(obj, update);
                    int size2 = list.size();
                    for (int i4 = 0; i4 < size2; i4++) {
                        Object obj2 = list.get(i4);
                        if (Document.this.mObjectIdMapper.containsObject(obj2) && ((elementInfo = update.getElementInfo(obj2)) == null || elementInfo.parentElement == obj)) {
                            childEventingListAcquireChildEventingList.add(obj2);
                        }
                    }
                    Document.updateListenerChildren(childEventingListAcquireChildEventingList, list2, this.insertedElements);
                    Document.this.releaseChildEventingList(childEventingListAcquireChildEventingList);
                }
            }
        });
        update.commit();
    }

    private void cleanUp() {
        this.mDocumentProvider.postAndWait(new Runnable() { // from class: com.facebook.stetho.inspector.elements.Document.2
            @Override // java.lang.Runnable
            public void run() {
                Document.this.mDocumentProvider.setListener(null);
                Document.this.mShadowDocument = null;
                Document.this.mObjectIdMapper.clear();
                Document.this.mDocumentProvider.dispose();
                Document.this.mDocumentProvider = null;
            }
        });
        this.mUpdateListeners.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShadowDocument.Update createShadowDocumentUpdate() {
        verifyThreadAccess();
        if (this.mDocumentProvider.getRootElement() != this.mShadowDocument.getRootElement()) {
            throw new IllegalStateException();
        }
        ArrayListAccumulator<Object> arrayListAccumulatorAcquireChildrenAccumulator = acquireChildrenAccumulator();
        ShadowDocument.UpdateBuilder updateBuilderBeginUpdate = this.mShadowDocument.beginUpdate();
        this.mCachedUpdateQueue.add(this.mDocumentProvider.getRootElement());
        while (!this.mCachedUpdateQueue.isEmpty()) {
            Object objRemove = this.mCachedUpdateQueue.remove();
            NodeDescriptor nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(objRemove);
            this.mObjectIdMapper.putObject(objRemove);
            nodeDescriptor.getChildren(objRemove, arrayListAccumulatorAcquireChildrenAccumulator);
            int size = arrayListAccumulatorAcquireChildrenAccumulator.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayListAccumulatorAcquireChildrenAccumulator.get(i3);
                if (obj != null) {
                    this.mCachedUpdateQueue.add(obj);
                } else {
                    LogUtil.e("%s.getChildren() emitted a null child at position %s for element %s", nodeDescriptor.getClass().getName(), Integer.toString(i3), objRemove);
                    arrayListAccumulatorAcquireChildrenAccumulator.remove(i3);
                    i3--;
                    size--;
                }
                i3++;
            }
            updateBuilderBeginUpdate.setElementChildren(objRemove, arrayListAccumulatorAcquireChildrenAccumulator);
            arrayListAccumulatorAcquireChildrenAccumulator.clear();
        }
        releaseChildrenAccumulator(arrayListAccumulatorAcquireChildrenAccumulator);
        return updateBuilderBeginUpdate.build();
    }

    private boolean doesElementMatch(Object obj, Pattern pattern) {
        AttributeListAccumulator attributeListAccumulatorAcquireCachedAttributeAccumulator = acquireCachedAttributeAccumulator();
        NodeDescriptor nodeDescriptor = this.mDocumentProvider.getNodeDescriptor(obj);
        nodeDescriptor.getAttributes(obj, attributeListAccumulatorAcquireCachedAttributeAccumulator);
        int size = attributeListAccumulatorAcquireCachedAttributeAccumulator.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (pattern.matcher(attributeListAccumulatorAcquireCachedAttributeAccumulator.get(i3)).find()) {
                releaseCachedAttributeAccumulator(attributeListAccumulatorAcquireCachedAttributeAccumulator);
                return true;
            }
        }
        releaseCachedAttributeAccumulator(attributeListAccumulatorAcquireCachedAttributeAccumulator);
        return pattern.matcher(nodeDescriptor.getNodeName(obj)).find();
    }

    private void findMatches(Object obj, Pattern pattern, Accumulator<Integer> accumulator) {
        ElementInfo elementInfo = this.mShadowDocument.getElementInfo(obj);
        int size = elementInfo.children.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj2 = elementInfo.children.get(i3);
            if (doesElementMatch(obj2, pattern)) {
                accumulator.store(this.mObjectIdMapper.getIdForObject(obj2));
            }
            findMatches(obj2, pattern, accumulator);
        }
    }

    private void init() {
        DocumentProvider documentProviderCreate = this.mFactory.create();
        this.mDocumentProvider = documentProviderCreate;
        documentProviderCreate.postAndWait(new Runnable() { // from class: com.facebook.stetho.inspector.elements.Document.1
            @Override // java.lang.Runnable
            public void run() {
                Document document = Document.this;
                document.mShadowDocument = new ShadowDocument(document.mDocumentProvider.getRootElement());
                Document.this.createShadowDocumentUpdate().commit();
                Document.this.mDocumentProvider.setListener(new ProviderListener());
            }
        });
    }

    private void releaseCachedAttributeAccumulator(AttributeListAccumulator attributeListAccumulator) {
        attributeListAccumulator.clear();
        if (this.mCachedAttributeAccumulator == null) {
            this.mCachedAttributeAccumulator = attributeListAccumulator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseChildEventingList(ChildEventingList childEventingList) {
        childEventingList.release();
        if (this.mCachedChildEventingList == null) {
            this.mCachedChildEventingList = childEventingList;
        }
    }

    private void releaseChildrenAccumulator(ArrayListAccumulator<Object> arrayListAccumulator) {
        arrayListAccumulator.clear();
        if (this.mCachedChildrenAccumulator == null) {
            this.mCachedChildrenAccumulator = arrayListAccumulator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateListenerChildren(ChildEventingList childEventingList, List<Object> list, Accumulator<Object> accumulator) {
        int i3 = 0;
        while (i3 <= childEventingList.size()) {
            if (i3 == childEventingList.size()) {
                if (i3 == list.size()) {
                    return;
                } else {
                    childEventingList.addWithEvent(i3, list.get(i3), accumulator);
                }
            } else if (i3 == list.size()) {
                childEventingList.removeWithEvent(i3);
            } else {
                Object obj = childEventingList.get(i3);
                Object obj2 = list.get(i3);
                if (obj != obj2) {
                    int iIndexOf = childEventingList.indexOf(obj2);
                    if (iIndexOf == -1) {
                        childEventingList.addWithEvent(i3, obj2, accumulator);
                    } else {
                        childEventingList.removeWithEvent(iIndexOf);
                        childEventingList.addWithEvent(i3, obj2, accumulator);
                    }
                }
            }
            i3++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTree() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ShadowDocument.Update updateCreateShadowDocumentUpdate = createShadowDocumentUpdate();
        boolean zIsEmpty = updateCreateShadowDocumentUpdate.isEmpty();
        if (zIsEmpty) {
            updateCreateShadowDocumentUpdate.abandon();
        } else {
            applyDocumentUpdate(updateCreateShadowDocumentUpdate);
        }
        LogUtil.d("Document.updateTree() completed in %s ms%s", Long.toString(SystemClock.elapsedRealtime() - jElapsedRealtime), zIsEmpty ? " (no changes)" : "");
    }

    public synchronized void addRef() {
        int i3 = this.mReferenceCounter;
        this.mReferenceCounter = i3 + 1;
        if (i3 == 0) {
            init();
        }
    }

    public void addUpdateListener(UpdateListener updateListener) {
        this.mUpdateListeners.add(updateListener);
    }

    public void findMatchingElements(String str, Accumulator<Integer> accumulator) {
        verifyThreadAccess();
        findMatches(this.mDocumentProvider.getRootElement(), Pattern.compile(Pattern.quote(str), 2), accumulator);
    }

    public DocumentView getDocumentView() {
        verifyThreadAccess();
        return this.mShadowDocument;
    }

    public void getElementComputedStyles(Object obj, ComputedStyleAccumulator computedStyleAccumulator) {
        getNodeDescriptor(obj).getComputedStyles(obj, computedStyleAccumulator);
    }

    @Nullable
    public Object getElementForNodeId(int i3) {
        return this.mObjectIdMapper.getObjectForId(i3);
    }

    public void getElementStyleRuleNames(Object obj, StyleRuleNameAccumulator styleRuleNameAccumulator) {
        getNodeDescriptor(obj).getStyleRuleNames(obj, styleRuleNameAccumulator);
    }

    public void getElementStyles(Object obj, String str, StyleAccumulator styleAccumulator) {
        getNodeDescriptor(obj).getStyles(obj, str, styleAccumulator);
    }

    @Nullable
    public NodeDescriptor getNodeDescriptor(Object obj) {
        verifyThreadAccess();
        return this.mDocumentProvider.getNodeDescriptor(obj);
    }

    @Nullable
    public Integer getNodeIdForElement(Object obj) {
        return this.mObjectIdMapper.getIdForObject(obj);
    }

    public Object getRootElement() {
        verifyThreadAccess();
        Object rootElement = this.mDocumentProvider.getRootElement();
        if (rootElement == null) {
            throw new IllegalStateException();
        }
        if (rootElement == this.mShadowDocument.getRootElement()) {
            return rootElement;
        }
        throw new IllegalStateException();
    }

    public void hideHighlight() {
        verifyThreadAccess();
        this.mDocumentProvider.hideHighlight();
    }

    public void highlightElement(Object obj, int i3) {
        verifyThreadAccess();
        this.mDocumentProvider.highlightElement(obj, i3);
    }

    public synchronized void release() {
        int i3 = this.mReferenceCounter;
        if (i3 > 0) {
            int i4 = i3 - 1;
            this.mReferenceCounter = i4;
            if (i4 == 0) {
                cleanUp();
            }
        }
    }

    public void removeUpdateListener(UpdateListener updateListener) {
        this.mUpdateListeners.remove(updateListener);
    }

    public void setAttributesAsText(Object obj, String str) {
        verifyThreadAccess();
        this.mDocumentProvider.setAttributesAsText(obj, str);
    }

    public void setElementStyle(Object obj, String str, String str2, String str3) {
        getNodeDescriptor(obj).setStyle(obj, str, str2, str3);
    }

    public void setInspectModeEnabled(boolean z2) {
        verifyThreadAccess();
        this.mDocumentProvider.setInspectModeEnabled(z2);
    }
}
