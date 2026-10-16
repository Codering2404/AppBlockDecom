package androidx.compose.ui.platform;

import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.collection.ArraySet;
import androidx.collection.IntList;
import androidx.collection.IntListKt;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableIntIntMap;
import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.AndroidComposeView;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.text.platform.URLSpanCache;
import androidx.compose.ui.util.ListUtilsKt;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    public static final Companion Q = new Companion(null);
    public static final int R = 8;
    private static final IntList S = IntListKt.d(R.id.f25128a, R.id.f25129b, R.id.f25140m, R.id.f25151x, R.id.A, R.id.B, R.id.C, R.id.D, R.id.E, R.id.F, R.id.f25130c, R.id.f25131d, R.id.f25132e, R.id.f25133f, R.id.f25134g, R.id.f25135h, R.id.f25136i, R.id.f25137j, R.id.f25138k, R.id.f25139l, R.id.f25141n, R.id.f25142o, R.id.f25143p, R.id.f25144q, R.id.f25145r, R.id.f25146s, R.id.f25147t, R.id.f25148u, R.id.f25149v, R.id.f25150w, R.id.f25152y, R.id.f25153z);
    private final Channel A;
    private boolean B;
    private PendingTextTraversedEvent C;
    private IntObjectMap D;
    private MutableIntSet E;
    private MutableIntIntMap F;
    private MutableIntIntMap G;
    private final String H;
    private final String I;
    private final URLSpanCache J;
    private MutableIntObjectMap K;
    private SemanticsNodeCopy L;
    private boolean M;
    private final Runnable N;
    private final List O;
    private final Function1 P;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AndroidComposeView f27766d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f27767e = Integer.MIN_VALUE;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Function1 f27768f = new Function1<AccessibilityEvent, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$onSendAccessibilityEvent$1
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(AccessibilityEvent accessibilityEvent) {
            return Boolean.valueOf(this.f27805a.i0().getParent().requestSendAccessibilityEvent(this.f27805a.i0(), accessibilityEvent));
        }
    };

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final android.view.accessibility.AccessibilityManager f27769g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27770h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private long f27771i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AccessibilityManager.AccessibilityStateChangeListener f27772j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final AccessibilityManager.TouchExplorationStateChangeListener f27773k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private List f27774l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final Handler f27775m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private ComposeAccessibilityNodeProvider f27776n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f27777o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f27778p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private AccessibilityNodeInfoCompat f27779q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private AccessibilityNodeInfoCompat f27780r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f27781s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MutableIntObjectMap f27782t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MutableIntObjectMap f27783u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SparseArrayCompat f27784v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private SparseArrayCompat f27785w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f27786x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Integer f27787y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final ArraySet f27788z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api24Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api24Impl f27790a = new Api24Impl();

        private Api24Impl() {
        }

        public static final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            AccessibilityAction accessibilityAction;
            if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.o(semanticsNode) || (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsActions.f28471a.x())) == null) {
                return;
            }
            accessibilityNodeInfoCompat.b(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionSetProgress, accessibilityAction.b()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Api29Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Api29Impl f27791a = new Api29Impl();

        private Api29Impl() {
        }

        public static final void a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, SemanticsNode semanticsNode) {
            Role role = (Role) SemanticsConfigurationKt.a(semanticsNode.w(), SemanticsProperties.f28517a.C());
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.o(semanticsNode)) {
                if (role == null ? false : Role.m(role.p(), Role.f28457b.b())) {
                    return;
                }
                SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
                SemanticsActions semanticsActions = SemanticsActions.f28471a;
                AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsConfigurationW, semanticsActions.r());
                if (accessibilityAction != null) {
                    accessibilityNodeInfoCompat.b(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageUp, accessibilityAction.b()));
                }
                AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsActions.o());
                if (accessibilityAction2 != null) {
                    accessibilityNodeInfoCompat.b(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageDown, accessibilityAction2.b()));
                }
                AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsActions.p());
                if (accessibilityAction3 != null) {
                    accessibilityNodeInfoCompat.b(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageLeft, accessibilityAction3.b()));
                }
                AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsActions.q());
                if (accessibilityAction4 != null) {
                    accessibilityNodeInfoCompat.b(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(android.R.id.accessibilityActionPageRight, accessibilityAction4.b()));
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class ComposeAccessibilityNodeProvider extends AccessibilityNodeProviderCompat {
        public ComposeAccessibilityNodeProvider() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public void a(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
            AndroidComposeViewAccessibilityDelegateCompat.this.M(i3, accessibilityNodeInfoCompat, str, bundle);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat b(int i3) {
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompatU = AndroidComposeViewAccessibilityDelegateCompat.this.U(i3);
            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
            if (androidComposeViewAccessibilityDelegateCompat.f27781s) {
                if (i3 == androidComposeViewAccessibilityDelegateCompat.f27777o) {
                    androidComposeViewAccessibilityDelegateCompat.f27779q = accessibilityNodeInfoCompatU;
                }
                if (i3 == androidComposeViewAccessibilityDelegateCompat.f27778p) {
                    androidComposeViewAccessibilityDelegateCompat.f27780r = accessibilityNodeInfoCompatU;
                }
            }
            return accessibilityNodeInfoCompatU;
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public AccessibilityNodeInfoCompat d(int i3) {
            if (i3 == 1) {
                if (AndroidComposeViewAccessibilityDelegateCompat.this.f27778p == Integer.MIN_VALUE) {
                    return null;
                }
                return b(AndroidComposeViewAccessibilityDelegateCompat.this.f27778p);
            }
            if (i3 == 2) {
                return b(AndroidComposeViewAccessibilityDelegateCompat.this.f27777o);
            }
            throw new IllegalArgumentException("Unknown focus type: " + i3);
        }

        @Override // androidx.core.view.accessibility.AccessibilityNodeProviderCompat
        public boolean f(int i3, int i4, Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.r0(i3, i4, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PendingTextTraversedEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final SemanticsNode f27793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f27795c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f27796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f27797e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f27798f;

        public PendingTextTraversedEvent(SemanticsNode semanticsNode, int i3, int i4, int i5, int i6, long j3) {
            this.f27793a = semanticsNode;
            this.f27794b = i3;
            this.f27795c = i4;
            this.f27796d = i5;
            this.f27797e = i6;
            this.f27798f = j3;
        }

        public final int a() {
            return this.f27794b;
        }

        public final int b() {
            return this.f27796d;
        }

        public final int c() {
            return this.f27795c;
        }

        public final SemanticsNode d() {
            return this.f27793a;
        }

        public final int e() {
            return this.f27797e;
        }

        public final long f() {
            return this.f27798f;
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(AndroidComposeView androidComposeView) {
        this.f27766d = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        android.view.accessibility.AccessibilityManager accessibilityManager = (android.view.accessibility.AccessibilityManager) systemService;
        this.f27769g = accessibilityManager;
        this.f27771i = 100L;
        this.f27772j = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: androidx.compose.ui.platform.g
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public final void onAccessibilityStateChanged(boolean z2) {
                AndroidComposeViewAccessibilityDelegateCompat.X(this.f28368a, z2);
            }
        };
        this.f27773k = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: androidx.compose.ui.platform.h
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public final void onTouchExplorationStateChanged(boolean z2) {
                AndroidComposeViewAccessibilityDelegateCompat.R0(this.f28369a, z2);
            }
        };
        this.f27774l = accessibilityManager.getEnabledAccessibilityServiceList(-1);
        this.f27775m = new Handler(Looper.getMainLooper());
        this.f27776n = new ComposeAccessibilityNodeProvider();
        this.f27777o = Integer.MIN_VALUE;
        this.f27778p = Integer.MIN_VALUE;
        this.f27782t = new MutableIntObjectMap(0, 1, null);
        this.f27783u = new MutableIntObjectMap(0, 1, null);
        this.f27784v = new SparseArrayCompat(0, 1, null);
        this.f27785w = new SparseArrayCompat(0, 1, null);
        this.f27786x = -1;
        this.f27788z = new ArraySet(0, 1, null);
        this.A = ChannelKt.b(1, null, null, 6, null);
        this.B = true;
        this.D = IntObjectMapKt.b();
        this.E = new MutableIntSet(0, 1, null);
        this.F = new MutableIntIntMap(0, 1, null);
        this.G = new MutableIntIntMap(0, 1, null);
        this.H = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALBEFORE_VAL";
        this.I = "android.view.accessibility.extra.EXTRA_DATA_TEST_TRAVERSALAFTER_VAL";
        this.J = new URLSpanCache();
        this.K = IntObjectMapKt.c();
        this.L = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().d(), IntObjectMapKt.b());
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.f27769g;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                accessibilityManager2.addAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f27772j);
                accessibilityManager2.addTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f27773k);
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                AndroidComposeViewAccessibilityDelegateCompat.this.f27775m.removeCallbacks(AndroidComposeViewAccessibilityDelegateCompat.this.N);
                android.view.accessibility.AccessibilityManager accessibilityManager2 = AndroidComposeViewAccessibilityDelegateCompat.this.f27769g;
                AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = AndroidComposeViewAccessibilityDelegateCompat.this;
                accessibilityManager2.removeAccessibilityStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f27772j);
                accessibilityManager2.removeTouchExplorationStateChangeListener(androidComposeViewAccessibilityDelegateCompat.f27773k);
            }
        });
        this.N = new Runnable() { // from class: androidx.compose.ui.platform.i
            @Override // java.lang.Runnable
            public final void run() {
                AndroidComposeViewAccessibilityDelegateCompat.A0(this.f28371a);
            }
        };
        this.O = new ArrayList();
        this.P = new Function1<ScrollObservationScope, Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeededLambda$1
            {
                super(1);
            }

            public final void c(ScrollObservationScope scrollObservationScope) {
                this.f27808a.z0(scrollObservationScope);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((ScrollObservationScope) obj);
                return Unit.f139807a;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Trace.beginSection("measureAndLayout");
        try {
            Owner.c(androidComposeViewAccessibilityDelegateCompat.f27766d, false, 1, null);
            Unit unit = Unit.f139807a;
            Trace.endSection();
            Trace.beginSection("checkForSemanticsChanges");
            try {
                androidComposeViewAccessibilityDelegateCompat.R();
                Trace.endSection();
                androidComposeViewAccessibilityDelegateCompat.M = false;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int B0(int i3) {
        if (i3 == this.f27766d.getSemanticsOwner().d().o()) {
            return -1;
        }
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void C0(androidx.compose.ui.semantics.SemanticsNode r17, androidx.compose.ui.platform.SemanticsNodeCopy r18) {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.C0(androidx.compose.ui.semantics.SemanticsNode, androidx.compose.ui.platform.SemanticsNodeCopy):void");
    }

    private final boolean D0(AccessibilityEvent accessibilityEvent) {
        if (!m0()) {
            return false;
        }
        if (accessibilityEvent.getEventType() == 2048 || accessibilityEvent.getEventType() == 32768) {
            this.f27781s = true;
        }
        try {
            return ((Boolean) this.f27768f.invoke(accessibilityEvent)).booleanValue();
        } finally {
            this.f27781s = false;
        }
    }

    private final boolean E0(int i3, int i4, Integer num, List list) {
        if (i3 == Integer.MIN_VALUE || !m0()) {
            return false;
        }
        AccessibilityEvent accessibilityEventT = T(i3, i4);
        if (num != null) {
            accessibilityEventT.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            accessibilityEventT.setContentDescription(ListUtilsKt.e(list, ",", null, null, 0, null, null, 62, null));
        }
        return D0(accessibilityEventT);
    }

    static /* synthetic */ boolean F0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i3, int i4, Integer num, List list, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            num = null;
        }
        if ((i5 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.E0(i3, i4, num, list);
    }

    private final void G0(int i3, int i4, String str) {
        AccessibilityEvent accessibilityEventT = T(B0(i3), 32);
        accessibilityEventT.setContentChangeTypes(i4);
        if (str != null) {
            accessibilityEventT.getText().add(str);
        }
        D0(accessibilityEventT);
    }

    private final void H0(int i3) {
        PendingTextTraversedEvent pendingTextTraversedEvent = this.C;
        if (pendingTextTraversedEvent != null) {
            if (i3 != pendingTextTraversedEvent.d().o()) {
                return;
            }
            if (SystemClock.uptimeMillis() - pendingTextTraversedEvent.f() <= 1000) {
                AccessibilityEvent accessibilityEventT = T(B0(pendingTextTraversedEvent.d().o()), 131072);
                accessibilityEventT.setFromIndex(pendingTextTraversedEvent.b());
                accessibilityEventT.setToIndex(pendingTextTraversedEvent.e());
                accessibilityEventT.setAction(pendingTextTraversedEvent.a());
                accessibilityEventT.setMovementGranularity(pendingTextTraversedEvent.c());
                accessibilityEventT.getText().add(f0(pendingTextTraversedEvent.d()));
                D0(accessibilityEventT);
            }
        }
        this.C = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:166:0x055b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void I0(androidx.collection.IntObjectMap r54) {
        /*
            Method dump skipped, instruction units count: 1701
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.I0(androidx.collection.IntObjectMap):void");
    }

    private final void J0(LayoutNode layoutNode, MutableIntSet mutableIntSet) {
        SemanticsConfiguration semanticsConfigurationQ;
        LayoutNode layoutNodeQ;
        if (layoutNode.m() && !this.f27766d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            if (!layoutNode.u0().q(NodeKind.a(8))) {
                layoutNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.q(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsNode$1
                    @Override // kotlin.jvm.functions.Function1
                    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                    public final Boolean invoke(LayoutNode layoutNode2) {
                        return Boolean.valueOf(layoutNode2.u0().q(NodeKind.a(8)));
                    }
                });
            }
            if (layoutNode == null || (semanticsConfigurationQ = layoutNode.Q()) == null) {
                return;
            }
            if (!semanticsConfigurationQ.p() && (layoutNodeQ = AndroidComposeViewAccessibilityDelegateCompat_androidKt.q(layoutNode, new Function1<LayoutNode, Boolean>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1
                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Boolean invoke(LayoutNode layoutNode2) {
                    SemanticsConfiguration semanticsConfigurationQ2 = layoutNode2.Q();
                    boolean z2 = false;
                    if (semanticsConfigurationQ2 != null && semanticsConfigurationQ2.p()) {
                        z2 = true;
                    }
                    return Boolean.valueOf(z2);
                }
            })) != null) {
                layoutNode = layoutNodeQ;
            }
            int iV = layoutNode.v();
            if (mutableIntSet.g(iV)) {
                F0(this, B0(iV), 2048, 1, null, 8, null);
            }
        }
    }

    private final void K0(LayoutNode layoutNode) {
        if (layoutNode.m() && !this.f27766d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            int iV = layoutNode.v();
            ScrollAxisRange scrollAxisRange = (ScrollAxisRange) this.f27782t.b(iV);
            ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) this.f27783u.b(iV);
            if (scrollAxisRange == null && scrollAxisRange2 == null) {
                return;
            }
            AccessibilityEvent accessibilityEventT = T(iV, 4096);
            if (scrollAxisRange != null) {
                accessibilityEventT.setScrollX((int) ((Number) scrollAxisRange.c().invoke()).floatValue());
                accessibilityEventT.setMaxScrollX((int) ((Number) scrollAxisRange.a().invoke()).floatValue());
            }
            if (scrollAxisRange2 != null) {
                accessibilityEventT.setScrollY((int) ((Number) scrollAxisRange2.c().invoke()).floatValue());
                accessibilityEventT.setMaxScrollY((int) ((Number) scrollAxisRange2.a().invoke()).floatValue());
            }
            D0(accessibilityEventT);
        }
    }

    private final boolean L0(SemanticsNode semanticsNode, int i3, int i4, boolean z2) {
        String strF0;
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsActions semanticsActions = SemanticsActions.f28471a;
        if (semanticsConfigurationW.d(semanticsActions.y()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.o(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.w().g(semanticsActions.y())).a();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(i3), Integer.valueOf(i4), Boolean.valueOf(z2))).booleanValue();
            }
            return false;
        }
        if ((i3 == i4 && i4 == this.f27786x) || (strF0 = f0(semanticsNode)) == null) {
            return false;
        }
        if (i3 < 0 || i3 != i4 || i4 > strF0.length()) {
            i3 = -1;
        }
        this.f27786x = i3;
        boolean z3 = strF0.length() > 0;
        D0(V(B0(semanticsNode.o()), z3 ? Integer.valueOf(this.f27786x) : null, z3 ? Integer.valueOf(this.f27786x) : null, z3 ? Integer.valueOf(strF0.length()) : null, strF0));
        H0(semanticsNode.o());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M(int i3, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
        SemanticsNode semanticsNodeB;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) a0().b(i3);
        if (semanticsNodeWithAdjustedBounds == null || (semanticsNodeB = semanticsNodeWithAdjustedBounds.b()) == null) {
            return;
        }
        String strF0 = f0(semanticsNodeB);
        if (Intrinsics.areEqual(str, this.H)) {
            int iE = this.F.e(i3, -1);
            if (iE != -1) {
                accessibilityNodeInfoCompat.t().putInt(str, iE);
                return;
            }
            return;
        }
        if (Intrinsics.areEqual(str, this.I)) {
            int iE2 = this.G.e(i3, -1);
            if (iE2 != -1) {
                accessibilityNodeInfoCompat.t().putInt(str, iE2);
                return;
            }
            return;
        }
        if (!semanticsNodeB.w().d(SemanticsActions.f28471a.i()) || bundle == null || !Intrinsics.areEqual(str, "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
            SemanticsConfiguration semanticsConfigurationW = semanticsNodeB.w();
            SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
            if (!semanticsConfigurationW.d(semanticsProperties.G()) || bundle == null || !Intrinsics.areEqual(str, "androidx.compose.ui.semantics.testTag")) {
                if (Intrinsics.areEqual(str, "androidx.compose.ui.semantics.id")) {
                    accessibilityNodeInfoCompat.t().putInt(str, semanticsNodeB.o());
                    return;
                }
                return;
            } else {
                String str2 = (String) SemanticsConfigurationKt.a(semanticsNodeB.w(), semanticsProperties.G());
                if (str2 != null) {
                    accessibilityNodeInfoCompat.t().putCharSequence(str, str2);
                    return;
                }
                return;
            }
        }
        int i4 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
        int i5 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
        if (i5 > 0 && i4 >= 0) {
            if (i4 < (strF0 != null ? strF0.length() : Api.BaseClientBuilder.API_PRIORITY_OTHER)) {
                TextLayoutResult textLayoutResultE = SemanticsUtils_androidKt.e(semanticsNodeB.w());
                if (textLayoutResultE == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (int i6 = 0; i6 < i5; i6++) {
                    int i7 = i4 + i6;
                    if (i7 >= textLayoutResultE.l().j().length()) {
                        arrayList.add(null);
                    } else {
                        arrayList.add(P0(semanticsNodeB, textLayoutResultE.d(i7)));
                    }
                }
                accessibilityNodeInfoCompat.t().putParcelableArray(str, (Parcelable[]) arrayList.toArray(new RectF[0]));
                return;
            }
        }
        Log.e("AccessibilityDelegate", "Invalid arguments for accessibility character locations");
    }

    private final void M0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        if (semanticsConfigurationW.d(semanticsProperties.h())) {
            accessibilityNodeInfoCompat.n0(true);
            accessibilityNodeInfoCompat.r0((CharSequence) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.h()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Rect N(SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds) {
        Rect rectA = semanticsNodeWithAdjustedBounds.a();
        AndroidComposeView androidComposeView = this.f27766d;
        float f3 = rectA.left;
        long jH = androidComposeView.H(Offset.e((((long) Float.floatToRawIntBits(rectA.top)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)));
        long jH2 = this.f27766d.H(Offset.e((((long) Float.floatToRawIntBits(rectA.right)) << 32) | (((long) Float.floatToRawIntBits(rectA.bottom)) & 4294967295L)));
        return new Rect((int) Math.floor(Float.intBitsToFloat((int) (jH >> 32))), (int) Math.floor(Float.intBitsToFloat((int) (jH & 4294967295L))), (int) Math.ceil(Float.intBitsToFloat((int) (jH2 >> 32))), (int) Math.ceil(Float.intBitsToFloat((int) (jH2 & 4294967295L))));
    }

    private final void O0(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        AnnotatedString annotatedStringU = AndroidComposeViewAccessibilityDelegateCompat_androidKt.u(semanticsNode);
        accessibilityNodeInfoCompat.Q0(annotatedStringU != null ? Q0(annotatedStringU) : null);
    }

    private final RectF P0(SemanticsNode semanticsNode, androidx.compose.ui.geometry.Rect rect) {
        if (semanticsNode == null) {
            return null;
        }
        androidx.compose.ui.geometry.Rect rectB = rect.B(semanticsNode.s());
        androidx.compose.ui.geometry.Rect rectI = semanticsNode.i();
        androidx.compose.ui.geometry.Rect rectX = rectB.z(rectI) ? rectB.x(rectI) : null;
        if (rectX == null) {
            return null;
        }
        AndroidComposeView androidComposeView = this.f27766d;
        float fO = rectX.o();
        long jH = androidComposeView.H(Offset.e((((long) Float.floatToRawIntBits(rectX.r())) & 4294967295L) | (((long) Float.floatToRawIntBits(fO)) << 32)));
        long jH2 = this.f27766d.H(Offset.e((((long) Float.floatToRawIntBits(rectX.p())) << 32) | (((long) Float.floatToRawIntBits(rectX.i())) & 4294967295L)));
        return new RectF(Float.intBitsToFloat((int) (jH >> 32)), Float.intBitsToFloat((int) (jH & 4294967295L)), Float.intBitsToFloat((int) (jH2 >> 32)), Float.intBitsToFloat((int) (jH2 & 4294967295L)));
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00e5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean Q(androidx.collection.IntObjectMap r21, boolean r22, int r23, long r24) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.Q(androidx.collection.IntObjectMap, boolean, int, long):boolean");
    }

    private final SpannableString Q0(AnnotatedString annotatedString) {
        return (SpannableString) T0(AndroidAccessibilitySpannableString_androidKt.b(annotatedString, this.f27766d.getDensity(), this.f27766d.getFontFamilyResolver(), this.J), 100000);
    }

    private final void R() {
        Trace.beginSection("sendAccessibilitySemanticsStructureChangeEvents");
        try {
            if (m0()) {
                C0(this.f27766d.getSemanticsOwner().d(), this.L);
            }
            Unit unit = Unit.f139807a;
            Trace.endSection();
            Trace.beginSection("sendSemanticsPropertyChangeEvents");
            try {
                I0(a0());
                Trace.endSection();
                Trace.beginSection("updateSemanticsNodesCopyAndPanes");
                try {
                    V0();
                } finally {
                }
            } finally {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R0(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z2) {
        androidComposeViewAccessibilityDelegateCompat.f27774l = androidComposeViewAccessibilityDelegateCompat.f27769g.getEnabledAccessibilityServiceList(-1);
    }

    private final boolean S(int i3) {
        if (!k0(i3)) {
            return false;
        }
        this.f27777o = Integer.MIN_VALUE;
        this.f27779q = null;
        this.f27766d.invalidate();
        F0(this, i3, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, null, null, 12, null);
        return true;
    }

    private final boolean S0(SemanticsNode semanticsNode, int i3, boolean z2, boolean z3) {
        int iZ;
        int i4;
        int iO = semanticsNode.o();
        Integer num = this.f27787y;
        if (num == null || iO != num.intValue()) {
            this.f27786x = -1;
            this.f27787y = Integer.valueOf(semanticsNode.o());
        }
        String strF0 = f0(semanticsNode);
        boolean z4 = false;
        if (strF0 != null && strF0.length() != 0) {
            AccessibilityIterators.TextSegmentIterator textSegmentIteratorG0 = g0(semanticsNode, i3);
            if (textSegmentIteratorG0 == null) {
                return false;
            }
            int iY = Y(semanticsNode);
            if (iY == -1) {
                iY = z2 ? 0 : strF0.length();
            }
            int[] iArrA = z2 ? textSegmentIteratorG0.a(iY) : textSegmentIteratorG0.b(iY);
            if (iArrA == null) {
                return false;
            }
            int i5 = iArrA[0];
            z4 = true;
            int i6 = iArrA[1];
            if (z3 && l0(semanticsNode)) {
                iZ = Z(semanticsNode);
                if (iZ == -1) {
                    iZ = z2 ? i5 : i6;
                }
                i4 = z2 ? i6 : i5;
            } else {
                iZ = z2 ? i6 : i5;
                i4 = iZ;
            }
            this.C = new PendingTextTraversedEvent(semanticsNode, z2 ? Function.MAX_NARGS : 512, i3, i5, i6, SystemClock.uptimeMillis());
            L0(semanticsNode, iZ, i4, true);
        }
        return z4;
    }

    private final AccessibilityEvent T(int i3, int i4) {
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds;
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i4);
        accessibilityEventObtain.setEnabled(true);
        accessibilityEventObtain.setClassName("android.view.View");
        accessibilityEventObtain.setPackageName(this.f27766d.getContext().getPackageName());
        accessibilityEventObtain.setSource(this.f27766d, i3);
        if (m0() && (semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) a0().b(i3)) != null) {
            accessibilityEventObtain.setPassword(semanticsNodeWithAdjustedBounds.b().w().d(SemanticsProperties.f28517a.A()));
        }
        return accessibilityEventObtain;
    }

    private final CharSequence T0(CharSequence charSequence, int i3) {
        if (i3 <= 0) {
            throw new IllegalArgumentException("size should be greater than 0");
        }
        if (charSequence == null || charSequence.length() == 0 || charSequence.length() <= i3) {
            return charSequence;
        }
        int i4 = i3 - 1;
        if (Character.isHighSurrogate(charSequence.charAt(i4)) && Character.isLowSurrogate(charSequence.charAt(i3))) {
            i3 = i4;
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(0, i3);
        Intrinsics.checkNotNull(charSequenceSubSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
        return charSequenceSubSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final AccessibilityNodeInfoCompat U(int i3) {
        LifecycleOwner lifecycleOwnerA;
        Lifecycle lifecycle;
        AndroidComposeView.ViewTreeOwners viewTreeOwners = this.f27766d.getViewTreeOwners();
        if (((viewTreeOwners == null || (lifecycleOwnerA = viewTreeOwners.a()) == null || (lifecycle = lifecycleOwnerA.getLifecycle()) == null) ? null : lifecycle.getCurrentState()) == Lifecycle.State.f39947a) {
            return null;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompatV = AccessibilityNodeInfoCompat.V();
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) a0().b(i3);
        if (semanticsNodeWithAdjustedBounds == null) {
            return null;
        }
        SemanticsNode semanticsNodeB = semanticsNodeWithAdjustedBounds.b();
        if (i3 == -1) {
            ViewParent parentForAccessibility = this.f27766d.getParentForAccessibility();
            accessibilityNodeInfoCompatV.E0(parentForAccessibility instanceof View ? (View) parentForAccessibility : null);
        } else {
            SemanticsNode semanticsNodeR = semanticsNodeB.r();
            Integer numValueOf = semanticsNodeR != null ? Integer.valueOf(semanticsNodeR.o()) : null;
            if (numValueOf == null) {
                InlineClassHelperKt.d("semanticsNode " + i3 + " has null parent");
                throw new KotlinNothingValueException();
            }
            int iIntValue = numValueOf.intValue();
            accessibilityNodeInfoCompatV.F0(this.f27766d, iIntValue != this.f27766d.getSemanticsOwner().d().o() ? iIntValue : -1);
        }
        accessibilityNodeInfoCompatV.O0(this.f27766d, i3);
        accessibilityNodeInfoCompatV.e0(N(semanticsNodeWithAdjustedBounds));
        u0(i3, accessibilityNodeInfoCompatV, semanticsNodeB);
        return accessibilityNodeInfoCompatV;
    }

    private final void U0(int i3) {
        int i4 = this.f27767e;
        if (i4 == i3) {
            return;
        }
        this.f27767e = i3;
        F0(this, i3, ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD, null, null, 12, null);
        F0(this, i4, Function.MAX_NARGS, null, null, 12, null);
    }

    private final AccessibilityEvent V(int i3, Integer num, Integer num2, Integer num3, CharSequence charSequence) {
        AccessibilityEvent accessibilityEventT = T(i3, Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if (num != null) {
            accessibilityEventT.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            accessibilityEventT.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            accessibilityEventT.setItemCount(num3.intValue());
        }
        if (charSequence != null) {
            accessibilityEventT.getText().add(charSequence);
        }
        return accessibilityEventT;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void V0() {
        /*
            Method dump skipped, instruction units count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.V0():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, boolean z2) {
        androidComposeViewAccessibilityDelegateCompat.f27774l = z2 ? androidComposeViewAccessibilityDelegateCompat.f27769g.getEnabledAccessibilityServiceList(-1) : CollectionsKt.emptyList();
    }

    private final int Y(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        return (semanticsConfigurationW.d(semanticsProperties.d()) || !semanticsNode.w().d(semanticsProperties.I())) ? this.f27786x : TextRange.i(((TextRange) semanticsNode.w().g(semanticsProperties.I())).r());
    }

    private final int Z(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        return (semanticsConfigurationW.d(semanticsProperties.d()) || !semanticsNode.w().d(semanticsProperties.I())) ? this.f27786x : TextRange.n(((TextRange) semanticsNode.w().g(semanticsProperties.I())).r());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IntObjectMap a0() {
        if (this.B) {
            this.B = false;
            this.D = SemanticsUtils_androidKt.b(this.f27766d.getSemanticsOwner());
            if (m0()) {
                AndroidComposeViewAccessibilityDelegateCompat_androidKt.z(this.D, this.F, this.G, this.f27766d.getContext().getResources());
            }
        }
        return this.D;
    }

    private final String f0(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        if (semanticsConfigurationW.d(semanticsProperties.d())) {
            return ListUtilsKt.e((List) semanticsNode.w().g(semanticsProperties.d()), ",", null, null, 0, null, null, 62, null);
        }
        if (semanticsNode.w().d(semanticsProperties.g())) {
            AnnotatedString annotatedStringH0 = h0(semanticsNode.w());
            if (annotatedStringH0 != null) {
                return annotatedStringH0.k();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.a(semanticsNode.w(), semanticsProperties.H());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.k();
    }

    private final AccessibilityIterators.TextSegmentIterator g0(SemanticsNode semanticsNode, int i3) {
        String strF0;
        TextLayoutResult textLayoutResultE;
        if (semanticsNode == null || (strF0 = f0(semanticsNode)) == null || strF0.length() == 0) {
            return null;
        }
        if (i3 == 1) {
            AccessibilityIterators.CharacterTextSegmentIterator characterTextSegmentIteratorA = AccessibilityIterators.CharacterTextSegmentIterator.f27650d.a(this.f27766d.getContext().getResources().getConfiguration().locale);
            characterTextSegmentIteratorA.e(strF0);
            return characterTextSegmentIteratorA;
        }
        if (i3 == 2) {
            AccessibilityIterators.WordTextSegmentIterator wordTextSegmentIteratorA = AccessibilityIterators.WordTextSegmentIterator.f27670d.a(this.f27766d.getContext().getResources().getConfiguration().locale);
            wordTextSegmentIteratorA.e(strF0);
            return wordTextSegmentIteratorA;
        }
        if (i3 != 4) {
            if (i3 == 8) {
                AccessibilityIterators.ParagraphTextSegmentIterator paragraphTextSegmentIteratorA = AccessibilityIterators.ParagraphTextSegmentIterator.f27668c.a();
                paragraphTextSegmentIteratorA.e(strF0);
                return paragraphTextSegmentIteratorA;
            }
            if (i3 != 16) {
                return null;
            }
        }
        if (!semanticsNode.w().d(SemanticsActions.f28471a.i()) || (textLayoutResultE = SemanticsUtils_androidKt.e(semanticsNode.w())) == null) {
            return null;
        }
        if (i3 == 4) {
            AccessibilityIterators.LineTextSegmentIterator lineTextSegmentIteratorA = AccessibilityIterators.LineTextSegmentIterator.f27654d.a();
            lineTextSegmentIteratorA.j(strF0, textLayoutResultE);
            return lineTextSegmentIteratorA;
        }
        AccessibilityIterators.PageTextSegmentIterator pageTextSegmentIteratorA = AccessibilityIterators.PageTextSegmentIterator.f27660f.a();
        pageTextSegmentIteratorA.j(strF0, textLayoutResultE, semanticsNode);
        return pageTextSegmentIteratorA;
    }

    private final AnnotatedString h0(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.a(semanticsConfiguration, SemanticsProperties.f28517a.g());
    }

    private final boolean k0(int i3) {
        return this.f27777o == i3;
    }

    private final boolean l0(SemanticsNode semanticsNode) {
        SemanticsConfiguration semanticsConfigurationW = semanticsNode.w();
        SemanticsProperties semanticsProperties = SemanticsProperties.f28517a;
        return !semanticsConfigurationW.d(semanticsProperties.d()) && semanticsNode.w().d(semanticsProperties.g());
    }

    private final boolean n0() {
        if (this.f27770h) {
            return true;
        }
        return this.f27769g.isEnabled() && this.f27769g.isTouchExplorationEnabled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o0(LayoutNode layoutNode) {
        if (this.f27788z.add(layoutNode)) {
            this.A.h(Unit.f139807a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:96:0x01b6 -> B:97:0x01b7). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:97:0x01b7
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:226)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:196)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:63)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:125)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.addCases(SwitchRegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:71)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:96)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:102)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public final boolean r0(int r20, int r21, android.os.Bundle r22) {
        /*
            Method dump skipped, instruction units count: 1898
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.r0(int, int, android.os.Bundle):boolean");
    }

    private static final boolean s0(ScrollAxisRange scrollAxisRange, float f3) {
        if (f3 >= 0.0f || ((Number) scrollAxisRange.c().invoke()).floatValue() <= 0.0f) {
            return f3 > 0.0f && ((Number) scrollAxisRange.c().invoke()).floatValue() < ((Number) scrollAxisRange.a().invoke()).floatValue();
        }
        return true;
    }

    private static final float t0(float f3, float f4) {
        if (Math.signum(f3) == Math.signum(f4)) {
            return Math.abs(f3) < Math.abs(f4) ? f3 : f4;
        }
        return 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x032b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void u0(int r17, androidx.core.view.accessibility.AccessibilityNodeInfoCompat r18, androidx.compose.ui.semantics.SemanticsNode r19) {
        /*
            Method dump skipped, instruction units count: 2206
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.u0(int, androidx.core.view.accessibility.AccessibilityNodeInfoCompat, androidx.compose.ui.semantics.SemanticsNode):void");
    }

    private static final boolean v0(ScrollAxisRange scrollAxisRange) {
        if (((Number) scrollAxisRange.c().invoke()).floatValue() <= 0.0f || scrollAxisRange.b()) {
            return ((Number) scrollAxisRange.c().invoke()).floatValue() < ((Number) scrollAxisRange.a().invoke()).floatValue() && scrollAxisRange.b();
        }
        return true;
    }

    private static final boolean w0(ScrollAxisRange scrollAxisRange) {
        if (((Number) scrollAxisRange.c().invoke()).floatValue() >= ((Number) scrollAxisRange.a().invoke()).floatValue() || scrollAxisRange.b()) {
            return ((Number) scrollAxisRange.c().invoke()).floatValue() > 0.0f && scrollAxisRange.b();
        }
        return true;
    }

    private final boolean x0(int i3, List list) {
        boolean z2;
        ScrollObservationScope scrollObservationScopeA = SemanticsUtils_androidKt.a(list, i3);
        if (scrollObservationScopeA != null) {
            z2 = false;
        } else {
            ScrollObservationScope scrollObservationScope = new ScrollObservationScope(i3, this.O, null, null, null, null);
            z2 = true;
            scrollObservationScopeA = scrollObservationScope;
        }
        this.O.add(scrollObservationScopeA);
        return z2;
    }

    private final boolean y0(int i3) {
        if (!n0() || k0(i3)) {
            return false;
        }
        int i4 = this.f27777o;
        if (i4 != Integer.MIN_VALUE) {
            F0(this, i4, NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST, null, null, 12, null);
        }
        this.f27777o = i3;
        this.f27766d.invalidate();
        F0(this, i3, 32768, null, null, 12, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z0(final ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.a1()) {
            this.f27766d.getSnapshotObserver().i(scrollObservationScope, this.P, new Function0<Unit>() { // from class: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$scheduleScrollEventIfNeeded$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Object invoke() {
                    m249invoke();
                    return Unit.f139807a;
                }

                /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
                public final void m249invoke() {
                    SemanticsNode semanticsNodeB;
                    LayoutNode layoutNodeQ;
                    ScrollAxisRange scrollAxisRangeA = scrollObservationScope.a();
                    ScrollAxisRange scrollAxisRangeE = scrollObservationScope.e();
                    Float fB = scrollObservationScope.b();
                    Float fC = scrollObservationScope.c();
                    float fFloatValue = (scrollAxisRangeA == null || fB == null) ? 0.0f : ((Number) scrollAxisRangeA.c().invoke()).floatValue() - fB.floatValue();
                    float fFloatValue2 = (scrollAxisRangeE == null || fC == null) ? 0.0f : ((Number) scrollAxisRangeE.c().invoke()).floatValue() - fC.floatValue();
                    if (fFloatValue != 0.0f || fFloatValue2 != 0.0f) {
                        int iB0 = this.B0(scrollObservationScope.d());
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = (SemanticsNodeWithAdjustedBounds) this.a0().b(this.f27777o);
                        if (semanticsNodeWithAdjustedBounds != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = this;
                            try {
                                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = androidComposeViewAccessibilityDelegateCompat.f27779q;
                                if (accessibilityNodeInfoCompat != null) {
                                    accessibilityNodeInfoCompat.e0(androidComposeViewAccessibilityDelegateCompat.N(semanticsNodeWithAdjustedBounds));
                                    Unit unit = Unit.f139807a;
                                }
                            } catch (IllegalStateException unused) {
                                Unit unit2 = Unit.f139807a;
                            }
                        }
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds2 = (SemanticsNodeWithAdjustedBounds) this.a0().b(this.f27778p);
                        if (semanticsNodeWithAdjustedBounds2 != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat2 = this;
                            try {
                                AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = androidComposeViewAccessibilityDelegateCompat2.f27780r;
                                if (accessibilityNodeInfoCompat2 != null) {
                                    accessibilityNodeInfoCompat2.e0(androidComposeViewAccessibilityDelegateCompat2.N(semanticsNodeWithAdjustedBounds2));
                                    Unit unit3 = Unit.f139807a;
                                }
                            } catch (IllegalStateException unused2) {
                                Unit unit4 = Unit.f139807a;
                            }
                        }
                        this.i0().invalidate();
                        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds3 = (SemanticsNodeWithAdjustedBounds) this.a0().b(iB0);
                        if (semanticsNodeWithAdjustedBounds3 != null && (semanticsNodeB = semanticsNodeWithAdjustedBounds3.b()) != null && (layoutNodeQ = semanticsNodeB.q()) != null) {
                            AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat3 = this;
                            if (scrollAxisRangeA != null) {
                                androidComposeViewAccessibilityDelegateCompat3.f27782t.r(iB0, scrollAxisRangeA);
                            }
                            if (scrollAxisRangeE != null) {
                                androidComposeViewAccessibilityDelegateCompat3.f27783u.r(iB0, scrollAxisRangeE);
                            }
                            androidComposeViewAccessibilityDelegateCompat3.o0(layoutNodeQ);
                        }
                    }
                    if (scrollAxisRangeA != null) {
                        scrollObservationScope.g((Float) scrollAxisRangeA.c().invoke());
                    }
                    if (scrollAxisRangeE != null) {
                        scrollObservationScope.h((Float) scrollAxisRangeE.c().invoke());
                    }
                }
            });
        }
    }

    public final void N0(long j3) {
        this.f27771i = j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00cf, code lost:
    
        if (kotlinx.coroutines.DelayKt.b(r8, r0) == r1) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x007f A[Catch: all -> 0x003a, TryCatch #1 {all -> 0x003a, blocks: (B:13:0x0035, B:25:0x0065, B:29:0x0077, B:31:0x007f, B:33:0x0088, B:35:0x0091, B:36:0x00a2, B:38:0x00a9, B:39:0x00b2, B:20:0x0051), top: B:50:0x0023 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00cf -> B:14:0x0038). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object O(kotlin.coroutines.Continuation r12) {
        /*
            Method dump skipped, instruction units count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.O(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean P(boolean z2, int i3, long j3) {
        if (Intrinsics.areEqual(Looper.getMainLooper().getThread(), Thread.currentThread())) {
            return Q(a0(), z2, i3, j3);
        }
        return false;
    }

    public final boolean W(MotionEvent motionEvent) {
        if (!n0()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int iJ0 = j0(motionEvent.getX(), motionEvent.getY());
            boolean zDispatchGenericMotionEvent = this.f27766d.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            U0(iJ0);
            if (iJ0 == Integer.MIN_VALUE) {
                return zDispatchGenericMotionEvent;
            }
            return true;
        }
        if (action != 10) {
            return false;
        }
        if (this.f27767e == Integer.MIN_VALUE) {
            return this.f27766d.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
        }
        U0(Integer.MIN_VALUE);
        return true;
    }

    @Override // androidx.core.view.AccessibilityDelegateCompat
    public AccessibilityNodeProviderCompat b(View view) {
        return this.f27776n;
    }

    public final String b0() {
        return this.I;
    }

    public final String c0() {
        return this.H;
    }

    public final MutableIntIntMap d0() {
        return this.G;
    }

    public final MutableIntIntMap e0() {
        return this.F;
    }

    public final AndroidComposeView i0() {
        return this.f27766d;
    }

    public final int j0(float f3, float f4) {
        int iB0;
        Owner.c(this.f27766d, false, 1, null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.L0(this.f27766d.getRoot(), Offset.e((((long) Float.floatToRawIntBits(f4)) & 4294967295L) | (Float.floatToRawIntBits(f3) << 32)), hitTestResult, 0, false, 12, null);
        int lastIndex = CollectionsKt.getLastIndex(hitTestResult);
        while (true) {
            iB0 = Integer.MIN_VALUE;
            if (-1 >= lastIndex) {
                break;
            }
            LayoutNode layoutNodeO = DelegatableNodeKt.o(hitTestResult.get(lastIndex));
            if (this.f27766d.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(layoutNodeO) != null) {
                return Integer.MIN_VALUE;
            }
            if (layoutNodeO.u0().q(NodeKind.a(8))) {
                iB0 = B0(layoutNodeO.v());
                SemanticsNode semanticsNodeA = SemanticsNodeKt.a(layoutNodeO, false);
                if (SemanticsUtils_androidKt.g(semanticsNodeA) && !semanticsNodeA.n().d(SemanticsProperties.f28517a.w())) {
                    break;
                }
            }
            lastIndex--;
        }
        return iB0;
    }

    public final boolean m0() {
        if (this.f27770h) {
            return true;
        }
        return this.f27769g.isEnabled() && !this.f27774l.isEmpty();
    }

    public final void p0(LayoutNode layoutNode) {
        this.B = true;
        if (m0()) {
            o0(layoutNode);
        }
    }

    public final void q0() {
        this.B = true;
        if (!m0() || this.M) {
            return;
        }
        this.M = true;
        this.f27775m.post(this.N);
    }
}
