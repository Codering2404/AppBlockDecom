package com.facebook.appevents.codeless;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListView;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.appevents.codeless.internal.Constants;
import com.facebook.appevents.codeless.internal.EventBinding;
import com.facebook.appevents.codeless.internal.ParameterComponent;
import com.facebook.appevents.codeless.internal.PathComponent;
import com.facebook.appevents.codeless.internal.ViewHierarchy;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.InternalSettings;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CodelessMatcher {
    private static final String CURRENT_CLASS_NAME = ".";
    private static final String PARENT_CLASS_NAME = "..";
    private static CodelessMatcher codelessMatcher;
    private final Set<Activity> activitiesSet;
    private final HashMap<Integer, HashSet<String>> activityToListenerMap;
    private HashSet<String> listenerSet;
    private final Handler uiThreadHandler;
    private final Set<ViewMatcher> viewMatchers;
    public static final Companion Companion = new Companion(null);
    private static final String TAG = CodelessMatcher.class.getCanonicalName();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final synchronized CodelessMatcher getInstance() {
            CodelessMatcher codelessMatcherAccess$getCodelessMatcher$cp;
            try {
                if (CodelessMatcher.access$getCodelessMatcher$cp() == null) {
                    CodelessMatcher.access$setCodelessMatcher$cp(new CodelessMatcher(null));
                }
                codelessMatcherAccess$getCodelessMatcher$cp = CodelessMatcher.access$getCodelessMatcher$cp();
                Intrinsics.checkNotNull(codelessMatcherAccess$getCodelessMatcher$cp, "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessMatcher");
            } catch (Throwable th) {
                throw th;
            }
            return codelessMatcherAccess$getCodelessMatcher$cp;
        }

        @JvmStatic
        public final Bundle getParameters(EventBinding eventBinding, View rootView, View hostView) {
            List<ParameterComponent> viewParameters;
            EventBinding eventBinding2;
            View view;
            List<MatchedView> listFindViewByPath;
            Intrinsics.checkNotNullParameter(rootView, "rootView");
            Intrinsics.checkNotNullParameter(hostView, "hostView");
            Bundle bundle = new Bundle();
            if (eventBinding != null && (viewParameters = eventBinding.getViewParameters()) != null) {
                for (ParameterComponent parameterComponent : viewParameters) {
                    if (parameterComponent.getValue() != null && parameterComponent.getValue().length() > 0) {
                        bundle.putString(parameterComponent.getName(), parameterComponent.getValue());
                    } else if (parameterComponent.getPath().size() > 0) {
                        if (Intrinsics.areEqual(parameterComponent.getPathType(), Constants.PATH_TYPE_RELATIVE)) {
                            ViewMatcher.Companion companion = ViewMatcher.Companion;
                            List<PathComponent> path = parameterComponent.getPath();
                            String simpleName = hostView.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName, "hostView.javaClass.simpleName");
                            EventBinding eventBinding3 = eventBinding;
                            listFindViewByPath = companion.findViewByPath(eventBinding3, hostView, path, 0, -1, simpleName);
                            eventBinding2 = eventBinding3;
                            view = rootView;
                        } else {
                            eventBinding2 = eventBinding;
                            ViewMatcher.Companion companion2 = ViewMatcher.Companion;
                            List<PathComponent> path2 = parameterComponent.getPath();
                            String simpleName2 = rootView.getClass().getSimpleName();
                            Intrinsics.checkNotNullExpressionValue(simpleName2, "rootView.javaClass.simpleName");
                            view = rootView;
                            listFindViewByPath = companion2.findViewByPath(eventBinding2, view, path2, 0, -1, simpleName2);
                        }
                        Iterator<MatchedView> it = listFindViewByPath.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            MatchedView next = it.next();
                            if (next.getView() != null) {
                                String textOfView = ViewHierarchy.getTextOfView(next.getView());
                                if (textOfView.length() > 0) {
                                    bundle.putString(parameterComponent.getName(), textOfView);
                                    break;
                                }
                            }
                        }
                        eventBinding = eventBinding2;
                        rootView = view;
                    }
                }
            }
            return bundle;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class MatchedView {
        private final WeakReference<View> view;
        private final String viewMapKey;

        public MatchedView(View view, String viewMapKey) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(viewMapKey, "viewMapKey");
            this.view = new WeakReference<>(view);
            this.viewMapKey = viewMapKey;
        }

        public final View getView() {
            WeakReference<View> weakReference = this.view;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        public final String getViewMapKey() {
            return this.viewMapKey;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ViewMatcher implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Runnable {
        public static final Companion Companion = new Companion(null);
        private final String activityName;
        private List<EventBinding> eventBindings;
        private final Handler handler;
        private final HashSet<String> listenerSet;
        private final WeakReference<View> rootView;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private final List<View> findVisibleChildren(ViewGroup viewGroup) {
                ArrayList arrayList = new ArrayList();
                int childCount = viewGroup.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View child = viewGroup.getChildAt(i3);
                    if (child.getVisibility() == 0) {
                        Intrinsics.checkNotNullExpressionValue(child, "child");
                        arrayList.add(child);
                    }
                }
                return arrayList;
            }

            /* JADX WARN: Code restructure failed: missing block: B:14:0x0065, code lost:
            
                if (kotlin.jvm.internal.Intrinsics.areEqual(r10.getClass().getSimpleName(), (java.lang.String) r12.get(r12.size() - 1)) == false) goto L15;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            private final boolean isTheSameView(android.view.View r10, com.facebook.appevents.codeless.internal.PathComponent r11, int r12) {
                /*
                    Method dump skipped, instruction units count: 323
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.Companion.isTheSameView(android.view.View, com.facebook.appevents.codeless.internal.PathComponent, int):boolean");
            }

            @JvmStatic
            public final List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> path, int i3, int i4, String mapKey) {
                EventBinding eventBinding2;
                List<PathComponent> list;
                Companion companion;
                Intrinsics.checkNotNullParameter(path, "path");
                Intrinsics.checkNotNullParameter(mapKey, "mapKey");
                String str = mapKey + '.' + i4;
                ArrayList arrayList = new ArrayList();
                if (view != null) {
                    if (i3 >= path.size()) {
                        arrayList.add(new MatchedView(view, str));
                        eventBinding2 = eventBinding;
                        list = path;
                        companion = this;
                    } else {
                        PathComponent pathComponent = path.get(i3);
                        if (Intrinsics.areEqual(pathComponent.getClassName(), "..")) {
                            ViewParent parent = view.getParent();
                            if (parent instanceof ViewGroup) {
                                List<View> listFindVisibleChildren = findVisibleChildren((ViewGroup) parent);
                                int size = listFindVisibleChildren.size();
                                int i5 = 0;
                                while (i5 < size) {
                                    EventBinding eventBinding3 = eventBinding;
                                    List<PathComponent> list2 = path;
                                    arrayList.addAll(findViewByPath(eventBinding3, listFindVisibleChildren.get(i5), list2, i3 + 1, i5, str));
                                    i5++;
                                    eventBinding = eventBinding3;
                                    path = list2;
                                }
                            }
                        } else {
                            eventBinding2 = eventBinding;
                            list = path;
                            companion = this;
                            if (Intrinsics.areEqual(pathComponent.getClassName(), CodelessMatcher.CURRENT_CLASS_NAME)) {
                                arrayList.add(new MatchedView(view, str));
                                return arrayList;
                            }
                            if (isTheSameView(view, pathComponent, i4)) {
                                if (i3 == list.size() - 1) {
                                    arrayList.add(new MatchedView(view, str));
                                }
                            }
                        }
                    }
                    if (view instanceof ViewGroup) {
                        List<View> listFindVisibleChildren2 = findVisibleChildren((ViewGroup) view);
                        int size2 = listFindVisibleChildren2.size();
                        int i6 = 0;
                        while (i6 < size2) {
                            arrayList.addAll(companion.findViewByPath(eventBinding2, listFindVisibleChildren2.get(i6), list, i3 + 1, i6, str));
                            i6++;
                            companion = this;
                        }
                    }
                }
                return arrayList;
            }

            private Companion() {
            }
        }

        public ViewMatcher(View view, Handler handler, HashSet<String> listenerSet, String activityName) {
            Intrinsics.checkNotNullParameter(handler, "handler");
            Intrinsics.checkNotNullParameter(listenerSet, "listenerSet");
            Intrinsics.checkNotNullParameter(activityName, "activityName");
            this.rootView = new WeakReference<>(view);
            this.handler = handler;
            this.listenerSet = listenerSet;
            this.activityName = activityName;
            handler.postDelayed(this, 200L);
        }

        private final void attachListener(MatchedView matchedView, View view, EventBinding eventBinding) {
            if (eventBinding == null) {
                return;
            }
            try {
                View view2 = matchedView.getView();
                if (view2 == null) {
                    return;
                }
                View viewFindRCTRootView = ViewHierarchy.findRCTRootView(view2);
                if (viewFindRCTRootView != null && ViewHierarchy.INSTANCE.isRCTButton(view2, viewFindRCTRootView)) {
                    attachRCTListener(matchedView, view, eventBinding);
                    return;
                }
                String name = view2.getClass().getName();
                Intrinsics.checkNotNullExpressionValue(name, "view.javaClass.name");
                if (StringsKt.U(name, "com.facebook.react", false, 2, null)) {
                    return;
                }
                if (!(view2 instanceof AdapterView)) {
                    attachOnClickListener(matchedView, view, eventBinding);
                } else if (view2 instanceof ListView) {
                    attachOnItemClickListener(matchedView, view, eventBinding);
                }
            } catch (Exception e3) {
                Utility.logd(CodelessMatcher.access$getTAG$cp(), e3);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void attachOnClickListener(com.facebook.appevents.codeless.CodelessMatcher.MatchedView r4, android.view.View r5, com.facebook.appevents.codeless.internal.EventBinding r6) {
            /*
                r3 = this;
                android.view.View r0 = r4.getView()
                if (r0 != 0) goto L7
                goto L39
            L7:
                java.lang.String r4 = r4.getViewMapKey()
                android.view.View$OnClickListener r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getExistingOnClickListener(r0)
                boolean r2 = r1 instanceof com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener
                if (r2 == 0) goto L22
                java.lang.String r2 = "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnClickListener r1 = (com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnClickListener) r1
                boolean r1 = r1.getSupportCodelessLogging()
                if (r1 == 0) goto L22
                r1 = 1
                goto L23
            L22:
                r1 = 0
            L23:
                java.util.HashSet<java.lang.String> r2 = r3.listenerSet
                boolean r2 = r2.contains(r4)
                if (r2 != 0) goto L39
                if (r1 != 0) goto L39
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnClickListener r5 = com.facebook.appevents.codeless.CodelessLoggingEventListener.getOnClickListener(r6, r5, r0)
                r0.setOnClickListener(r5)
                java.util.HashSet<java.lang.String> r5 = r3.listenerSet
                r5.add(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.attachOnClickListener(com.facebook.appevents.codeless.CodelessMatcher$MatchedView, android.view.View, com.facebook.appevents.codeless.internal.EventBinding):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void attachOnItemClickListener(com.facebook.appevents.codeless.CodelessMatcher.MatchedView r4, android.view.View r5, com.facebook.appevents.codeless.internal.EventBinding r6) {
            /*
                r3 = this;
                android.view.View r0 = r4.getView()
                android.widget.AdapterView r0 = (android.widget.AdapterView) r0
                if (r0 != 0) goto L9
                goto L3b
            L9:
                java.lang.String r4 = r4.getViewMapKey()
                android.widget.AdapterView$OnItemClickListener r1 = r0.getOnItemClickListener()
                boolean r2 = r1 instanceof com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener
                if (r2 == 0) goto L24
                java.lang.String r2 = "null cannot be cast to non-null type com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnItemClickListener r1 = (com.facebook.appevents.codeless.CodelessLoggingEventListener.AutoLoggingOnItemClickListener) r1
                boolean r1 = r1.getSupportCodelessLogging()
                if (r1 == 0) goto L24
                r1 = 1
                goto L25
            L24:
                r1 = 0
            L25:
                java.util.HashSet<java.lang.String> r2 = r3.listenerSet
                boolean r2 = r2.contains(r4)
                if (r2 != 0) goto L3b
                if (r1 != 0) goto L3b
                com.facebook.appevents.codeless.CodelessLoggingEventListener$AutoLoggingOnItemClickListener r5 = com.facebook.appevents.codeless.CodelessLoggingEventListener.getOnItemClickListener(r6, r5, r0)
                r0.setOnItemClickListener(r5)
                java.util.HashSet<java.lang.String> r5 = r3.listenerSet
                r5.add(r4)
            L3b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.attachOnItemClickListener(com.facebook.appevents.codeless.CodelessMatcher$MatchedView, android.view.View, com.facebook.appevents.codeless.internal.EventBinding):void");
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final void attachRCTListener(com.facebook.appevents.codeless.CodelessMatcher.MatchedView r4, android.view.View r5, com.facebook.appevents.codeless.internal.EventBinding r6) {
            /*
                r3 = this;
                android.view.View r0 = r4.getView()
                if (r0 != 0) goto L7
                goto L39
            L7:
                java.lang.String r4 = r4.getViewMapKey()
                android.view.View$OnTouchListener r1 = com.facebook.appevents.codeless.internal.ViewHierarchy.getExistingOnTouchListener(r0)
                boolean r2 = r1 instanceof com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener
                if (r2 == 0) goto L22
                java.lang.String r2 = "null cannot be cast to non-null type com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
                com.facebook.appevents.codeless.RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener r1 = (com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.AutoLoggingOnTouchListener) r1
                boolean r1 = r1.getSupportCodelessLogging()
                if (r1 == 0) goto L22
                r1 = 1
                goto L23
            L22:
                r1 = 0
            L23:
                java.util.HashSet<java.lang.String> r2 = r3.listenerSet
                boolean r2 = r2.contains(r4)
                if (r2 != 0) goto L39
                if (r1 != 0) goto L39
                com.facebook.appevents.codeless.RCTCodelessLoggingEventListener$AutoLoggingOnTouchListener r5 = com.facebook.appevents.codeless.RCTCodelessLoggingEventListener.getOnTouchListener(r6, r5, r0)
                r0.setOnTouchListener(r5)
                java.util.HashSet<java.lang.String> r5 = r3.listenerSet
                r5.add(r4)
            L39:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.CodelessMatcher.ViewMatcher.attachRCTListener(com.facebook.appevents.codeless.CodelessMatcher$MatchedView, android.view.View, com.facebook.appevents.codeless.internal.EventBinding):void");
        }

        private final void findView(EventBinding eventBinding, View view) {
            if (eventBinding == null || view == null) {
                return;
            }
            String activityName = eventBinding.getActivityName();
            if (activityName == null || activityName.length() == 0 || Intrinsics.areEqual(eventBinding.getActivityName(), this.activityName)) {
                List<PathComponent> viewPath = eventBinding.getViewPath();
                if (viewPath.size() > 25) {
                    return;
                }
                Iterator<MatchedView> it = Companion.findViewByPath(eventBinding, view, viewPath, 0, -1, this.activityName).iterator();
                while (it.hasNext()) {
                    attachListener(it.next(), view, eventBinding);
                }
            }
        }

        @JvmStatic
        public static final List<MatchedView> findViewByPath(EventBinding eventBinding, View view, List<PathComponent> list, int i3, int i4, String str) {
            return Companion.findViewByPath(eventBinding, view, list, i3, i4, str);
        }

        private final void startMatch() {
            List<EventBinding> list = this.eventBindings;
            if (list == null || this.rootView.get() == null) {
                return;
            }
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                findView(list.get(i3), this.rootView.get());
            }
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            startMatch();
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            startMatch();
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                FetchedAppSettings appSettingsWithoutQuery = FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId());
                if (appSettingsWithoutQuery != null && appSettingsWithoutQuery.getCodelessEventsEnabled()) {
                    List<EventBinding> array = EventBinding.Companion.parseArray(appSettingsWithoutQuery.getEventBindings());
                    this.eventBindings = array;
                    if (array != null && (view = this.rootView.get()) != null) {
                        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                        if (viewTreeObserver.isAlive()) {
                            viewTreeObserver.addOnGlobalLayoutListener(this);
                            viewTreeObserver.addOnScrollChangedListener(this);
                        }
                        startMatch();
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public /* synthetic */ CodelessMatcher(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ CodelessMatcher access$getCodelessMatcher$cp() {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return null;
        }
        try {
            return codelessMatcher;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
            return null;
        }
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return null;
        }
        try {
            return TAG;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
            return null;
        }
    }

    public static final /* synthetic */ void access$setCodelessMatcher$cp(CodelessMatcher codelessMatcher2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return;
        }
        try {
            codelessMatcher = codelessMatcher2;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
        }
    }

    @JvmStatic
    public static final synchronized CodelessMatcher getInstance() {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return null;
        }
        try {
            return Companion.getInstance();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
            return null;
        }
    }

    @JvmStatic
    public static final Bundle getParameters(EventBinding eventBinding, View view, View view2) {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return null;
        }
        try {
            return Companion.getParameters(eventBinding, view, view2);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
            return null;
        }
    }

    private final void matchViews() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            for (Activity activity : this.activitiesSet) {
                if (activity != null) {
                    View rootView = AppEventUtility.getRootView(activity);
                    String activityName = activity.getClass().getSimpleName();
                    Handler handler = this.uiThreadHandler;
                    HashSet<String> hashSet = this.listenerSet;
                    Intrinsics.checkNotNullExpressionValue(activityName, "activityName");
                    this.viewMatchers.add(new ViewMatcher(rootView, handler, hashSet, activityName));
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private final void startTracking() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                matchViews();
            } else {
                this.uiThreadHandler.post(new Runnable() { // from class: com.facebook.appevents.codeless.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        CodelessMatcher.startTracking$lambda$1(this.f68025a);
                    }
                });
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startTracking$lambda$1(CodelessMatcher this$0) {
        if (CrashShieldHandler.isObjectCrashing(CodelessMatcher.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.matchViews();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, CodelessMatcher.class);
        }
    }

    public final void add(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (InternalSettings.isUnityApp()) {
                return;
            }
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't add activity to CodelessMatcher on non-UI thread");
            }
            this.activitiesSet.add(activity);
            this.listenerSet.clear();
            HashSet<String> hashSet = this.activityToListenerMap.get(Integer.valueOf(activity.hashCode()));
            if (hashSet != null) {
                this.listenerSet = hashSet;
            }
            startTracking();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void destroy(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            this.activityToListenerMap.remove(Integer.valueOf(activity.hashCode()));
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void remove(Activity activity) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(activity, "activity");
            if (InternalSettings.isUnityApp()) {
                return;
            }
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                throw new FacebookException("Can't remove activity from CodelessMatcher on non-UI thread");
            }
            this.activitiesSet.remove(activity);
            this.viewMatchers.clear();
            HashMap<Integer, HashSet<String>> map = this.activityToListenerMap;
            Integer numValueOf = Integer.valueOf(activity.hashCode());
            Object objClone = this.listenerSet.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type java.util.HashSet<kotlin.String>{ kotlin.collections.TypeAliasesKt.HashSet<kotlin.String> }");
            map.put(numValueOf, (HashSet) objClone);
            this.listenerSet.clear();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    private CodelessMatcher() {
        this.uiThreadHandler = new Handler(Looper.getMainLooper());
        Set<Activity> setNewSetFromMap = Collections.newSetFromMap(new WeakHashMap());
        Intrinsics.checkNotNullExpressionValue(setNewSetFromMap, "newSetFromMap(WeakHashMap())");
        this.activitiesSet = setNewSetFromMap;
        this.viewMatchers = new LinkedHashSet();
        this.listenerSet = new HashSet<>();
        this.activityToListenerMap = new HashMap<>();
    }
}
