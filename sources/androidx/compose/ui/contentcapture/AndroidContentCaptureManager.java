package androidx.compose.ui.contentcapture;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.LongSparseArray;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.translation.TranslationResponseValue;
import android.view.translation.ViewTranslationResponse;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.ui.contentcapture.AndroidContentCaptureManager;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.platform.SemanticsNodeCopy;
import androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds;
import androidx.compose.ui.platform.SemanticsUtils_androidKt;
import androidx.compose.ui.platform.coreshims.AutofillIdCompat;
import androidx.compose.ui.platform.coreshims.ContentCaptureSessionCompat;
import androidx.compose.ui.platform.coreshims.ViewCompatShims;
import androidx.compose.ui.platform.coreshims.ViewStructureCompat;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertyKey;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutInput;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class AndroidContentCaptureManager implements ContentCaptureManager, DefaultLifecycleObserver, View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f25287q = new Companion(null);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f25288r = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AndroidComposeView f25289a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Function0 f25290b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ContentCaptureSessionCompat f25291c;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f25299l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private SemanticsNodeCopy f25301n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f25302o;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List f25292d = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f25293f = 100;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private TranslateStatus f25294g = TranslateStatus.f25304a;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f25295h = true;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Channel f25296i = ChannelKt.b(1, null, null, 6, null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Handler f25297j = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private IntObjectMap f25298k = IntObjectMapKt.b();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private MutableIntObjectMap f25300m = IntObjectMapKt.c();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final Runnable f25303p = new Runnable() { // from class: androidx.compose.ui.contentcapture.a
        @Override // java.lang.Runnable
        public final void run() {
            AndroidContentCaptureManager.k(this.f25328a);
        }
    };

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class TranslateStatus {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TranslateStatus f25304a = new TranslateStatus("SHOW_ORIGINAL", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final TranslateStatus f25305b = new TranslateStatus("SHOW_TRANSLATED", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ TranslateStatus[] f25306c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f25307d;

        static {
            TranslateStatus[] translateStatusArrA = a();
            f25306c = translateStatusArrA;
            f25307d = EnumEntriesKt.a(translateStatusArrA);
        }

        private TranslateStatus(String str, int i3) {
        }

        private static final /* synthetic */ TranslateStatus[] a() {
            return new TranslateStatus[]{f25304a, f25305b};
        }

        public static TranslateStatus valueOf(String str) {
            return (TranslateStatus) Enum.valueOf(TranslateStatus.class, str);
        }

        public static TranslateStatus[] values() {
            return (TranslateStatus[]) f25306c.clone();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class ViewTranslationHelperMethods {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ViewTranslationHelperMethods f25308a = new ViewTranslationHelperMethods();

        private ViewTranslationHelperMethods() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private final void b(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            TranslationResponseValue value;
            CharSequence text;
            SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
            SemanticsNode semanticsNodeB;
            AccessibilityAction accessibilityAction;
            Function1 function1;
            int size = longSparseArray.size();
            for (int i3 = 0; i3 < size; i3++) {
                long jKeyAt = longSparseArray.keyAt(i3);
                ViewTranslationResponse viewTranslationResponseA = e.a(longSparseArray.get(jKeyAt));
                if (viewTranslationResponseA != null && (value = viewTranslationResponseA.getValue("android:text")) != null && (text = value.getText()) != null && (semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) androidContentCaptureManager.m().b((int) jKeyAt)) != null && (semanticsNodeB = semanticsNodeWithAdjustedBounds.b()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsNodeB.w(), SemanticsActions.f28471a.A())) != null && (function1 = (Function1) accessibilityAction.a()) != null) {
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
            f25308a.b(androidContentCaptureManager, longSparseArray);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:14:0x006d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void c(androidx.compose.ui.contentcapture.AndroidContentCaptureManager r15, long[] r16, int[] r17, java.util.function.Consumer r18) {
            /*
                r14 = this;
                r0 = r16
                int r1 = r0.length
                r2 = 0
            L4:
                if (r2 >= r1) goto L72
                r3 = r0[r2]
                androidx.collection.IntObjectMap r5 = r15.m()
                int r3 = (int) r3
                java.lang.Object r3 = r5.b(r3)
                androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r3 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r3
                if (r3 == 0) goto L6d
                androidx.compose.ui.semantics.SemanticsNode r3 = r3.b()
                if (r3 != 0) goto L1c
                goto L6d
            L1c:
                androidx.compose.ui.contentcapture.i.a()
                androidx.compose.ui.platform.AndroidComposeView r4 = r15.n()
                android.view.autofill.AutofillId r4 = r4.getAutofillId()
                int r5 = r3.o()
                long r5 = (long) r5
                android.view.translation.ViewTranslationRequest$Builder r4 = androidx.compose.ui.contentcapture.h.a(r4, r5)
                androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.w()
                androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.f28517a
                androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.H()
                java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.a(r3, r5)
                r5 = r3
                java.util.List r5 = (java.util.List) r5
                if (r5 == 0) goto L6d
                r12 = 62
                r13 = 0
                java.lang.String r6 = "\n"
                r7 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                r11 = 0
                java.lang.String r3 = androidx.compose.ui.util.ListUtilsKt.e(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                if (r3 == 0) goto L6d
                androidx.compose.ui.text.AnnotatedString r5 = new androidx.compose.ui.text.AnnotatedString
                r6 = 0
                r7 = 2
                r5.<init>(r3, r6, r7, r6)
                java.lang.String r3 = "android:text"
                android.view.translation.TranslationRequestValue r5 = androidx.compose.ui.contentcapture.b.a(r5)
                androidx.compose.ui.contentcapture.c.a(r4, r3, r5)
                android.view.translation.ViewTranslationRequest r3 = androidx.compose.ui.contentcapture.d.a(r4)
                r4 = r18
                r4.accept(r3)
                goto L6f
            L6d:
                r4 = r18
            L6f:
                int r2 = r2 + 1
                goto L4
            L72:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.ViewTranslationHelperMethods.c(androidx.compose.ui.contentcapture.AndroidContentCaptureManager, long[], int[], java.util.function.Consumer):void");
        }

        public final void d(final AndroidContentCaptureManager androidContentCaptureManager, final LongSparseArray longSparseArray) {
            if (Build.VERSION.SDK_INT < 31) {
                return;
            }
            if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
                b(androidContentCaptureManager, longSparseArray);
            } else {
                androidContentCaptureManager.n().post(new Runnable() { // from class: androidx.compose.ui.contentcapture.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        AndroidContentCaptureManager.ViewTranslationHelperMethods.e(androidContentCaptureManager, longSparseArray);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public /* synthetic */ class WhenMappings {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25309a;

        static {
            int[] iArr = new int[ContentCaptureEventType.values().length];
            try {
                iArr[ContentCaptureEventType.f25322a.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ContentCaptureEventType.f25323b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f25309a = iArr;
        }
    }

    public AndroidContentCaptureManager(AndroidComposeView androidComposeView, Function0 function0) {
        this.f25289a = androidComposeView;
        this.f25290b = function0;
        this.f25301n = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().d(), IntObjectMapKt.b());
    }

    private final void A() {
        MutableIntObjectMap mutableIntObjectMap = this.f25300m;
        int[] iArr = mutableIntObjectMap.f2886b;
        long[] jArr = mutableIntObjectMap.f2885a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        int i6 = iArr[(i3 << 3) + i5];
                        if (!m().a(i6)) {
                            g(i6);
                            r();
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private final void B(int i3, String str) {
        ContentCaptureSessionCompat contentCaptureSessionCompat;
        if (Build.VERSION.SDK_INT >= 29 && (contentCaptureSessionCompat = this.f25291c) != null) {
            AutofillId autofillIdB = contentCaptureSessionCompat.b(i3);
            if (autofillIdB != null) {
                contentCaptureSessionCompat.f(autofillIdB, str);
            } else {
                InlineClassHelperKt.d("Invalid content capture ID");
                throw new KotlinNothingValueException();
            }
        }
    }

    private final void C() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap intObjectMapM = m();
        Object[] objArr = intObjectMapM.f2887c;
        long[] jArr = intObjectMapM.f2885a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        SemanticsConfiguration semanticsConfigurationW = ((SemanticsNodeWithAdjustedBounds) objArr[(i3 << 3) + i5]).b().w();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsProperties.f28517a.u()), Boolean.FALSE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsActions.f28471a.B())) != null && (function1 = (Function1) accessibilityAction.a()) != null) {
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private final ViewStructureCompat D(SemanticsNode semanticsNode, int i3) {
        AutofillIdCompat autofillIdCompatA;
        AutofillId autofillIdA;
        String strI;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.f25291c;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || (autofillIdCompatA = ViewCompatShims.a(this.f25289a)) == null) {
            return null;
        }
        if (semanticsNode.r() != null) {
            autofillIdA = contentCaptureSessionCompat.b(r4.o());
            if (autofillIdA == null) {
                return null;
            }
        } else {
            autofillIdA = autofillIdCompatA.a();
        }
        ViewStructureCompat viewStructureCompatC = contentCaptureSessionCompat.c(autofillIdA, semanticsNode.o());
        if (viewStructureCompatC == null) {
            return null;
        }
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        if (semanticsConfigurationW.d(semanticsProperties.A())) {
            return null;
        }
        Bundle bundleA = viewStructureCompatC.a();
        if (bundleA != null) {
            bundleA.putLong("android.view.contentcapture.EventTimestamp", this.f25299l);
            bundleA.putInt("android.view.ViewStructure.extra.EXTRA_VIEW_NODE_INDEX", i3);
        }
        String str = (String) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.G());
        if (str != null) {
            viewStructureCompatC.e(semanticsNode.o(), null, null, str);
        }
        if (((Boolean) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.v())) != null) {
            viewStructureCompatC.b("android.widget.ViewGroup");
        }
        List list = (List) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.H());
        if (list != null) {
            viewStructureCompatC.b("android.widget.TextView");
            viewStructureCompatC.f(ListUtilsKt.e(list, "\n", null, null, 0, null, null, 62, null));
        }
        AnnotatedString annotatedString = (AnnotatedString) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.g());
        if (annotatedString != null) {
            viewStructureCompatC.b("android.widget.EditText");
            viewStructureCompatC.f(annotatedString);
        }
        List list2 = (List) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.d());
        if (list2 != null) {
            viewStructureCompatC.c(ListUtilsKt.e(list2, "\n", null, null, 0, null, null, 62, null));
        }
        Role role = (Role) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsProperties.C());
        if (role != null && (strI = SemanticsUtils_androidKt.i(role.p())) != null) {
            viewStructureCompatC.b(strI);
        }
        TextLayoutResult textLayoutResultE = SemanticsUtils_androidKt.e(semanticsConfigurationW);
        if (textLayoutResultE != null) {
            TextLayoutInput textLayoutInputL = textLayoutResultE.l();
            viewStructureCompatC.g(TextUnit.h(textLayoutInputL.i().n()) * textLayoutInputL.b().getDensity() * textLayoutInputL.b().K1(), 0, 0, 0);
        }
        Rect rectH = semanticsNode.h();
        viewStructureCompatC.d((int) rectH.o(), (int) rectH.r(), 0, 0, (int) (rectH.p() - rectH.o()), (int) (rectH.i() - rectH.r()));
        return viewStructureCompatC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(int i3, SemanticsNode semanticsNode) {
        if (p()) {
            H(semanticsNode);
            f(semanticsNode.o(), D(semanticsNode, i3));
            l(semanticsNode, new Function2<Integer, SemanticsNode, Unit>() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$updateBuffersOnAppeared$1
                {
                    super(2);
                }

                public final void c(int i4, SemanticsNode semanticsNode2) {
                    this.f25317a.E(i4, semanticsNode2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    c(((Number) obj).intValue(), (SemanticsNode) obj2);
                    return Unit.f139807a;
                }
            });
        }
    }

    private final void F(SemanticsNode semanticsNode) {
        if (p()) {
            g(semanticsNode.o());
            List listT = semanticsNode.t();
            int size = listT.size();
            for (int i3 = 0; i3 < size; i3++) {
                F((SemanticsNode) listT.get(i3));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void G() {
        /*
            r16 = this;
            r0 = r16
            androidx.collection.MutableIntObjectMap r1 = r0.f25300m
            r1.g()
            androidx.collection.IntObjectMap r1 = r0.m()
            int[] r2 = r1.f2886b
            java.lang.Object[] r3 = r1.f2887c
            long[] r1 = r1.f2885a
            int r4 = r1.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L62
            r6 = 0
        L17:
            r7 = r1[r6]
            long r9 = ~r7
            r11 = 7
            long r9 = r9 << r11
            long r9 = r9 & r7
            r11 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r9 = r9 & r11
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 == 0) goto L5d
            int r9 = r6 - r4
            int r9 = ~r9
            int r9 = r9 >>> 31
            r10 = 8
            int r9 = 8 - r9
            r11 = 0
        L31:
            if (r11 >= r9) goto L5b
            r12 = 255(0xff, double:1.26E-321)
            long r12 = r12 & r7
            r14 = 128(0x80, double:6.3E-322)
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 >= 0) goto L57
            int r12 = r6 << 3
            int r12 = r12 + r11
            r13 = r2[r12]
            r12 = r3[r12]
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r12 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r12
            androidx.collection.MutableIntObjectMap r14 = r0.f25300m
            androidx.compose.ui.platform.SemanticsNodeCopy r15 = new androidx.compose.ui.platform.SemanticsNodeCopy
            androidx.compose.ui.semantics.SemanticsNode r12 = r12.b()
            androidx.collection.IntObjectMap r5 = r0.m()
            r15.<init>(r12, r5)
            r14.r(r13, r15)
        L57:
            long r7 = r7 >> r10
            int r11 = r11 + 1
            goto L31
        L5b:
            if (r9 != r10) goto L62
        L5d:
            if (r6 == r4) goto L62
            int r6 = r6 + 1
            goto L17
        L62:
            androidx.compose.ui.platform.SemanticsNodeCopy r1 = new androidx.compose.ui.platform.SemanticsNodeCopy
            androidx.compose.ui.platform.AndroidComposeView r2 = r0.f25289a
            androidx.compose.ui.semantics.SemanticsOwner r2 = r2.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.d()
            androidx.collection.IntObjectMap r3 = r0.m()
            r1.<init>(r2, r3)
            r0.f25301n = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.G():void");
    }

    private final void H(SemanticsNode semanticsNode) {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        Function1 function12;
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        Boolean bool = (Boolean) SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsProperties.f28517a.u());
        if (this.f25294g == TranslateStatus.f25304a && Intrinsics.areEqual(bool, Boolean.TRUE)) {
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsActions.f28471a.B());
            if (accessibilityAction2 == null || (function12 = (Function1) accessibilityAction2.a()) == null) {
                return;
            }
            return;
        }
        if (this.f25294g != TranslateStatus.f25305b || !Intrinsics.areEqual(bool, Boolean.FALSE) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsActions.f28471a.B())) == null || (function1 = (Function1) accessibilityAction.a()) == null) {
            return;
        }
    }

    private final void f(int i3, ViewStructureCompat viewStructureCompat) {
        if (viewStructureCompat == null) {
            return;
        }
        this.f25292d.add(new ContentCaptureEvent(i3, this.f25299l, ContentCaptureEventType.f25322a, viewStructureCompat));
    }

    private final void g(int i3) {
        this.f25292d.add(new ContentCaptureEvent(i3, this.f25299l, ContentCaptureEventType.f25323b, null));
    }

    private final void h(IntObjectMap intObjectMap) {
        int[] iArr;
        long[] jArr;
        int[] iArr2;
        long[] jArr2;
        long j3;
        char c3;
        long j4;
        int i3;
        SemanticsNode semanticsNode;
        int i4;
        SemanticsNode semanticsNode2;
        long j5;
        int i5;
        long[] jArr3;
        IntObjectMap intObjectMap2 = intObjectMap;
        int[] iArr3 = intObjectMap2.f2886b;
        long[] jArr4 = intObjectMap2.f2885a;
        int length = jArr4.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j6 = jArr4[i6];
            char c4 = 7;
            long j7 = -9187201950435737472L;
            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8;
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                int i9 = 0;
                while (i9 < i8) {
                    if ((j6 & 255) < 128) {
                        int i10 = iArr3[(i6 << 3) + i9];
                        c3 = c4;
                        SemanticsNodeCopy semanticsNodeCopy = (SemanticsNodeCopy) this.f25300m.b(i10);
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) intObjectMap2.b(i10);
                        SemanticsNode semanticsNodeB = semanticsNodeWithAdjustedBounds != null ? semanticsNodeWithAdjustedBounds.b() : null;
                        if (semanticsNodeB == null) {
                            InlineClassHelperKt.d("no value for specified key");
                            throw new KotlinNothingValueException();
                        }
                        if (semanticsNodeCopy == null) {
                            MutableScatterMap mutableScatterMapN = semanticsNodeB.w().n();
                            j4 = j7;
                            Object[] objArr = mutableScatterMapN.f3109b;
                            long[] jArr5 = mutableScatterMapN.f3108a;
                            int length2 = jArr5.length - 2;
                            if (length2 >= 0) {
                                int i11 = 0;
                                int i12 = i7;
                                while (true) {
                                    long j8 = jArr5[i11];
                                    iArr2 = iArr3;
                                    if ((((~j8) << c3) & j8 & j4) != j4) {
                                        int i13 = 8 - ((~(i11 - length2)) >>> 31);
                                        int i14 = 0;
                                        while (i14 < i13) {
                                            if ((j8 & 255) < 128) {
                                                i5 = i14;
                                                SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) objArr[(i11 << 3) + i14];
                                                SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
                                                jArr3 = jArr4;
                                                if (Intrinsics.areEqual(semanticsPropertyKey, semanticsProperties.H())) {
                                                    List list = (List) SemanticsConfigurationKt.a(semanticsNodeB.w(), semanticsProperties.H());
                                                    B(semanticsNodeB.o(), String.valueOf(list != null ? (AnnotatedString) CollectionsKt.firstOrNull(list) : null));
                                                }
                                            } else {
                                                i5 = i14;
                                                jArr3 = jArr4;
                                            }
                                            j8 >>= i12;
                                            i14 = i5 + 1;
                                            jArr4 = jArr3;
                                        }
                                        jArr2 = jArr4;
                                        if (i13 != i12) {
                                            break;
                                        }
                                    } else {
                                        jArr2 = jArr4;
                                    }
                                    if (i11 == length2) {
                                        break;
                                    }
                                    i11++;
                                    iArr3 = iArr2;
                                    jArr4 = jArr2;
                                    i12 = 8;
                                }
                            } else {
                                iArr2 = iArr3;
                                jArr2 = jArr4;
                            }
                        } else {
                            iArr2 = iArr3;
                            jArr2 = jArr4;
                            j4 = j7;
                            MutableScatterMap mutableScatterMapN2 = semanticsNodeB.w().n();
                            Object[] objArr2 = mutableScatterMapN2.f3109b;
                            long[] jArr6 = mutableScatterMapN2.f3108a;
                            int length3 = jArr6.length - 2;
                            if (length3 >= 0) {
                                int i15 = 0;
                                while (true) {
                                    long j9 = jArr6[i15];
                                    long[] jArr7 = jArr6;
                                    Object[] objArr3 = objArr2;
                                    if ((((~j9) << c3) & j9 & j4) != j4) {
                                        int i16 = 8 - ((~(i15 - length3)) >>> 31);
                                        int i17 = 0;
                                        while (i17 < i16) {
                                            if ((j9 & 255) < 128) {
                                                i4 = i17;
                                                SemanticsPropertyKey semanticsPropertyKey2 = (SemanticsPropertyKey) objArr3[(i15 << 3) + i17];
                                                SemanticsProperties semanticsProperties2 = SemanticsProperties.f28517a;
                                                semanticsNode2 = semanticsNodeB;
                                                if (Intrinsics.areEqual(semanticsPropertyKey2, semanticsProperties2.H())) {
                                                    List list2 = (List) SemanticsConfigurationKt.a(semanticsNodeCopy.b(), semanticsProperties2.H());
                                                    AnnotatedString annotatedString = list2 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list2) : null;
                                                    j5 = j6;
                                                    List list3 = (List) SemanticsConfigurationKt.a(semanticsNode2.w(), semanticsProperties2.H());
                                                    AnnotatedString annotatedString2 = list3 != null ? (AnnotatedString) CollectionsKt.firstOrNull(list3) : null;
                                                    if (!Intrinsics.areEqual(annotatedString, annotatedString2)) {
                                                        B(semanticsNode2.o(), String.valueOf(annotatedString2));
                                                    }
                                                }
                                                j9 >>= 8;
                                                i17 = i4 + 1;
                                                semanticsNodeB = semanticsNode2;
                                                j6 = j5;
                                            } else {
                                                i4 = i17;
                                                semanticsNode2 = semanticsNodeB;
                                            }
                                            j5 = j6;
                                            j9 >>= 8;
                                            i17 = i4 + 1;
                                            semanticsNodeB = semanticsNode2;
                                            j6 = j5;
                                        }
                                        semanticsNode = semanticsNodeB;
                                        j3 = j6;
                                        if (i16 != 8) {
                                            break;
                                        }
                                    } else {
                                        semanticsNode = semanticsNodeB;
                                        j3 = j6;
                                    }
                                    if (i15 == length3) {
                                        break;
                                    }
                                    i15++;
                                    objArr2 = objArr3;
                                    jArr6 = jArr7;
                                    semanticsNodeB = semanticsNode;
                                    j6 = j3;
                                }
                            }
                            i3 = 8;
                        }
                        j3 = j6;
                        i3 = 8;
                    } else {
                        iArr2 = iArr3;
                        jArr2 = jArr4;
                        j3 = j6;
                        c3 = c4;
                        j4 = j7;
                        i3 = i7;
                    }
                    j6 = j3 >> i3;
                    i9++;
                    intObjectMap2 = intObjectMap;
                    i7 = i3;
                    c4 = c3;
                    j7 = j4;
                    iArr3 = iArr2;
                    jArr4 = jArr2;
                }
                iArr = iArr3;
                jArr = jArr4;
                if (i8 != i7) {
                    return;
                }
            } else {
                iArr = iArr3;
                jArr = jArr4;
            }
            if (i6 == length) {
                return;
            }
            i6++;
            intObjectMap2 = intObjectMap;
            iArr3 = iArr;
            jArr4 = jArr;
        }
    }

    private final void i() {
        AccessibilityAction accessibilityAction;
        Function0 function0;
        IntObjectMap intObjectMapM = m();
        Object[] objArr = intObjectMapM.f2887c;
        long[] jArr = intObjectMapM.f2885a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        SemanticsConfiguration semanticsConfigurationW = ((SemanticsNodeWithAdjustedBounds) objArr[(i3 << 3) + i5]).b().w();
                        if (SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsProperties.f28517a.u()) != null && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsActions.f28471a.a())) != null && (function0 = (Function0) accessibilityAction.a()) != null) {
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(AndroidContentCaptureManager androidContentCaptureManager) {
        if (androidContentCaptureManager.p()) {
            Owner.c(androidContentCaptureManager.f25289a, false, 1, null);
            androidContentCaptureManager.A();
            androidContentCaptureManager.z(androidContentCaptureManager.f25289a.getSemanticsOwner().d(), androidContentCaptureManager.f25301n);
            androidContentCaptureManager.h(androidContentCaptureManager.m());
            androidContentCaptureManager.G();
            androidContentCaptureManager.f25302o = false;
        }
    }

    private final void l(SemanticsNode semanticsNode, Function2 function2) {
        List listT = semanticsNode.t();
        int size = listT.size();
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Object obj = listT.get(i4);
            if (m().a(((SemanticsNode) obj).o())) {
                function2.invoke(Integer.valueOf(i3), obj);
                i3++;
            }
        }
    }

    private final void o() {
        AccessibilityAction accessibilityAction;
        Function1 function1;
        IntObjectMap intObjectMapM = m();
        Object[] objArr = intObjectMapM.f2887c;
        long[] jArr = intObjectMapM.f2885a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            long j3 = jArr[i3];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i4 = 8 - ((~(i3 - length)) >>> 31);
                for (int i5 = 0; i5 < i4; i5++) {
                    if ((255 & j3) < 128) {
                        SemanticsConfiguration semanticsConfigurationW = ((SemanticsNodeWithAdjustedBounds) objArr[(i3 << 3) + i5]).b().w();
                        if (Intrinsics.areEqual(SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsProperties.f28517a.u()), Boolean.TRUE) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfigurationW, SemanticsActions.f28471a.B())) != null && (function1 = (Function1) accessibilityAction.a()) != null) {
                        }
                    }
                    j3 >>= 8;
                }
                if (i4 != 8) {
                    return;
                }
            }
            if (i3 == length) {
                return;
            } else {
                i3++;
            }
        }
    }

    private final void q() {
        AutofillId autofillIdB;
        ContentCaptureSessionCompat contentCaptureSessionCompat = this.f25291c;
        if (contentCaptureSessionCompat == null || Build.VERSION.SDK_INT < 29 || this.f25292d.isEmpty()) {
            return;
        }
        List list = this.f25292d;
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            ContentCaptureEvent contentCaptureEvent = (ContentCaptureEvent) list.get(i3);
            int i4 = WhenMappings.f25309a[contentCaptureEvent.c().ordinal()];
            if (i4 == 1) {
                ViewStructureCompat viewStructureCompatB = contentCaptureEvent.b();
                if (viewStructureCompatB != null) {
                    contentCaptureSessionCompat.d(viewStructureCompatB.h());
                }
            } else if (i4 == 2 && (autofillIdB = contentCaptureSessionCompat.b(contentCaptureEvent.a())) != null) {
                contentCaptureSessionCompat.e(autofillIdB);
            }
        }
        contentCaptureSessionCompat.a();
        this.f25292d.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        this.f25296i.h(Unit.f139807a);
    }

    private final void z(SemanticsNode semanticsNode, final SemanticsNodeCopy semanticsNodeCopy) {
        l(semanticsNode, new Function2<Integer, SemanticsNode, Unit>() { // from class: androidx.compose.ui.contentcapture.AndroidContentCaptureManager$sendContentCaptureAppearEvents$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final void c(int i3, SemanticsNode semanticsNode2) {
                if (semanticsNodeCopy.a().a(semanticsNode2.o())) {
                    return;
                }
                this.E(i3, semanticsNode2);
                this.r();
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                c(((Number) obj).intValue(), (SemanticsNode) obj2);
                return Unit.f139807a;
            }
        });
        List listT = semanticsNode.t();
        int size = listT.size();
        for (int i3 = 0; i3 < size; i3++) {
            SemanticsNode semanticsNode2 = (SemanticsNode) listT.get(i3);
            if (m().a(semanticsNode2.o()) && this.f25300m.a(semanticsNode2.o())) {
                Object objB = this.f25300m.b(semanticsNode2.o());
                if (objB == null) {
                    InlineClassHelperKt.d("node not present in pruned tree before this change");
                    throw new KotlinNothingValueException();
                }
                z(semanticsNode2, (SemanticsNodeCopy) objB);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0092, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r6, r0) == r1) goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x0092 -> B:13:0x0033). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object e(kotlin.coroutines.Continuation r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L13
            r0 = r10
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1) r0
            int r1 = r0.f25314f
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f25314f = r1
            goto L18
        L13:
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.contentcapture.AndroidContentCaptureManager$boundsUpdatesEventLoop$1
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f25312c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f25314f
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r2 = r0.f25311b
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.f25310a
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.b(r10)
        L33:
            r10 = r2
            r2 = r5
            goto L54
        L36:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L3e:
            java.lang.Object r2 = r0.f25311b
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.f25310a
            androidx.compose.ui.contentcapture.AndroidContentCaptureManager r5 = (androidx.compose.ui.contentcapture.AndroidContentCaptureManager) r5
            kotlin.ResultKt.b(r10)
            goto L65
        L4a:
            kotlin.ResultKt.b(r10)
            kotlinx.coroutines.channels.Channel r10 = r9.f25296i
            kotlinx.coroutines.channels.ChannelIterator r10 = r10.iterator()
            r2 = r9
        L54:
            r0.f25310a = r2
            r0.f25311b = r10
            r0.f25314f = r4
            java.lang.Object r5 = r10.a(r0)
            if (r5 != r1) goto L61
            goto L94
        L61:
            r8 = r2
            r2 = r10
            r10 = r5
            r5 = r8
        L65:
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L95
            r2.next()
            boolean r10 = r5.p()
            if (r10 == 0) goto L79
            r5.q()
        L79:
            boolean r10 = r5.f25302o
            if (r10 != 0) goto L86
            r5.f25302o = r4
            android.os.Handler r10 = r5.f25297j
            java.lang.Runnable r6 = r5.f25303p
            r10.post(r6)
        L86:
            long r6 = r5.f25293f
            r0.f25310a = r5
            r0.f25311b = r2
            r0.f25314f = r3
            java.lang.Object r10 = kotlinx.coroutines.DelayKt.b(r6, r0)
            if (r10 != r1) goto L33
        L94:
            return r1
        L95:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.contentcapture.AndroidContentCaptureManager.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final IntObjectMap m() {
        if (this.f25295h) {
            this.f25295h = false;
            this.f25298k = SemanticsUtils_androidKt.b(this.f25289a.getSemanticsOwner());
            this.f25299l = System.currentTimeMillis();
        }
        return this.f25298k;
    }

    public final AndroidComposeView n() {
        return this.f25289a;
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        this.f25291c = (ContentCaptureSessionCompat) this.f25290b.invoke();
        E(-1, this.f25289a.getSemanticsOwner().d());
        q();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        F(this.f25289a.getSemanticsOwner().d());
        q();
        this.f25291c = null;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.f25297j.removeCallbacks(this.f25303p);
        this.f25291c = null;
    }

    public final boolean p() {
        return ContentCaptureManager.d8.a() && this.f25291c != null;
    }

    public final void s() {
        this.f25294g = TranslateStatus.f25304a;
        i();
    }

    public final void t(long[] jArr, int[] iArr, Consumer consumer) {
        ViewTranslationHelperMethods.f25308a.c(this, jArr, iArr, consumer);
    }

    public final void u() {
        this.f25294g = TranslateStatus.f25304a;
        o();
    }

    public final void v() {
        this.f25295h = true;
        if (p()) {
            r();
        }
    }

    public final void w() {
        this.f25295h = true;
        if (!p() || this.f25302o) {
            return;
        }
        this.f25302o = true;
        this.f25297j.post(this.f25303p);
    }

    public final void x() {
        this.f25294g = TranslateStatus.f25305b;
        C();
    }

    public final void y(AndroidContentCaptureManager androidContentCaptureManager, LongSparseArray longSparseArray) {
        ViewTranslationHelperMethods.f25308a.d(androidContentCaptureManager, longSparseArray);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }
}
