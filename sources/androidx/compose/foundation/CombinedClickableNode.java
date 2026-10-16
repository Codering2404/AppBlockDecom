package androidx.compose.foundation;

import android.view.KeyEvent;
import androidx.collection.LongObjectMapKt;
import androidx.collection.MutableLongObjectMap;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.HapticFeedbackType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Job;

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
final class CombinedClickableNode extends AbstractClickableNode implements CompositionLocalConsumerModifierNode {
    private final MutableLongObjectMap A;
    private final MutableLongObjectMap B;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f4864w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Function0 f4865x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Function0 f4866y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private boolean f4867z;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class DoubleKeyClickState {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Job f4868a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f4869b;

        public DoubleKeyClickState(Job job) {
            this.f4868a = job;
        }

        public final boolean a() {
            return this.f4869b;
        }

        public final Job b() {
            return this.f4868a;
        }

        public final void c(boolean z2) {
            this.f4869b = z2;
        }
    }

    public /* synthetic */ CombinedClickableNode(Function0 function0, String str, Function0 function02, Function0 function03, boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, String str2, Role role, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, str, function02, function03, z2, mutableInteractionSource, indicationNodeFactory, z3, str2, role);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0094  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void U2() {
        /*
            r24 = this;
            r0 = r24
            androidx.collection.MutableLongObjectMap r1 = r0.A
            java.lang.Object[] r2 = r1.f2933c
            long[] r3 = r1.f2931a
            int r4 = r3.length
            int r4 = r4 + (-2)
            r9 = 7
            r10 = 0
            r13 = 1
            r14 = 8
            r15 = 0
            if (r4 < 0) goto L4d
            r5 = r15
            r16 = 128(0x80, double:6.3E-322)
            r18 = 255(0xff, double:1.26E-321)
        L18:
            r7 = r3[r5]
            r20 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = ~r7
            long r11 = r11 << r9
            long r11 = r11 & r7
            long r11 = r11 & r20
            int r6 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r6 == 0) goto L48
            int r6 = r5 - r4
            int r6 = ~r6
            int r6 = r6 >>> 31
            int r6 = 8 - r6
            r11 = r15
        L30:
            if (r11 >= r6) goto L46
            long r22 = r7 & r18
            int r12 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r12 >= 0) goto L42
            int r12 = r5 << 3
            int r12 = r12 + r11
            r12 = r2[r12]
            kotlinx.coroutines.Job r12 = (kotlinx.coroutines.Job) r12
            kotlinx.coroutines.Job.DefaultImpls.b(r12, r10, r13, r10)
        L42:
            long r7 = r7 >> r14
            int r11 = r11 + 1
            goto L30
        L46:
            if (r6 != r14) goto L56
        L48:
            if (r5 == r4) goto L56
            int r5 = r5 + 1
            goto L18
        L4d:
            r16 = 128(0x80, double:6.3E-322)
            r18 = 255(0xff, double:1.26E-321)
            r20 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
        L56:
            r1.g()
            androidx.collection.MutableLongObjectMap r1 = r0.B
            java.lang.Object[] r2 = r1.f2933c
            long[] r3 = r1.f2931a
            int r4 = r3.length
            int r4 = r4 + (-2)
            if (r4 < 0) goto L99
            r5 = r15
        L65:
            r6 = r3[r5]
            long r11 = ~r6
            long r11 = r11 << r9
            long r11 = r11 & r6
            long r11 = r11 & r20
            int r8 = (r11 > r20 ? 1 : (r11 == r20 ? 0 : -1))
            if (r8 == 0) goto L94
            int r8 = r5 - r4
            int r8 = ~r8
            int r8 = r8 >>> 31
            int r8 = 8 - r8
            r11 = r15
        L78:
            if (r11 >= r8) goto L92
            long r22 = r6 & r18
            int r12 = (r22 > r16 ? 1 : (r22 == r16 ? 0 : -1))
            if (r12 >= 0) goto L8e
            int r12 = r5 << 3
            int r12 = r12 + r11
            r12 = r2[r12]
            androidx.compose.foundation.CombinedClickableNode$DoubleKeyClickState r12 = (androidx.compose.foundation.CombinedClickableNode.DoubleKeyClickState) r12
            kotlinx.coroutines.Job r12 = r12.b()
            kotlinx.coroutines.Job.DefaultImpls.b(r12, r10, r13, r10)
        L8e:
            long r6 = r6 >> r14
            int r11 = r11 + 1
            goto L78
        L92:
            if (r8 != r14) goto L99
        L94:
            if (r5 == r4) goto L99
            int r5 = r5 + 1
            goto L65
        L99:
            r1.g()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.CombinedClickableNode.U2():void");
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public Object A2(PointerInputScope pointerInputScope, Continuation continuation) {
        Object objL = TapGestureDetectorKt.l(pointerInputScope, (!F2() || this.f4866y == null) ? null : new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNode$clickPointerInput$2
            {
                super(1);
            }

            public final void c(long j3) {
                Function0 function0 = this.f4871a.f4866y;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Offset) obj).u());
                return Unit.f139807a;
            }
        }, (!F2() || this.f4865x == null) ? null : new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNode$clickPointerInput$3
            {
                super(1);
            }

            public final void c(long j3) {
                Function0 function0 = this.f4872a.f4865x;
                if (function0 != null) {
                    function0.invoke();
                }
                if (this.f4872a.T2()) {
                    ((HapticFeedback) CompositionLocalConsumerModifierNodeKt.a(this.f4872a, CompositionLocalsKt.k())).a(HapticFeedbackType.f26611b.e());
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Offset) obj).u());
                return Unit.f139807a;
            }
        }, new CombinedClickableNode$clickPointerInput$4(this, null), new Function1<Offset, Unit>() { // from class: androidx.compose.foundation.CombinedClickableNode$clickPointerInput$5
            {
                super(1);
            }

            public final void c(long j3) {
                if (this.f4877a.F2()) {
                    this.f4877a.G2().invoke();
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c(((Offset) obj).u());
                return Unit.f139807a;
            }
        }, continuation);
        return objL == IntrinsicsKt.f() ? objL : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    protected void J2() {
        U2();
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    protected boolean K2(KeyEvent keyEvent) {
        boolean z2;
        long jA = KeyEvent_androidKt.a(keyEvent);
        if (this.f4865x == null || this.A.b(jA) != null) {
            z2 = false;
        } else {
            this.A.r(jA, BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyDownEvent$1(this, null), 3, null));
            z2 = true;
        }
        DoubleKeyClickState doubleKeyClickState = (DoubleKeyClickState) this.B.b(jA);
        if (doubleKeyClickState != null) {
            if (doubleKeyClickState.b().isActive()) {
                Job.DefaultImpls.b(doubleKeyClickState.b(), null, 1, null);
                if (!doubleKeyClickState.a()) {
                    G2().invoke();
                    this.B.o(jA);
                    return z2;
                }
            } else {
                this.B.o(jA);
            }
        }
        return z2;
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    protected boolean L2(KeyEvent keyEvent) {
        Function0 function0;
        long jA = KeyEvent_androidKt.a(keyEvent);
        boolean z2 = false;
        if (this.A.b(jA) != null) {
            Job job = (Job) this.A.b(jA);
            if (job != null) {
                if (job.isActive()) {
                    Job.DefaultImpls.b(job, null, 1, null);
                } else {
                    z2 = true;
                }
            }
            this.A.o(jA);
        }
        if (this.f4866y != null) {
            if (this.B.b(jA) != null) {
                if (!z2 && (function0 = this.f4866y) != null) {
                    function0.invoke();
                }
                this.B.o(jA);
            } else if (!z2) {
                this.B.r(jA, new DoubleKeyClickState(BuildersKt__Builders_commonKt.d(getCoroutineScope(), null, null, new CombinedClickableNode$onClickKeyUpEvent$2(this, jA, null), 3, null)));
            }
        } else if (!z2) {
            G2().invoke();
        }
        return true;
    }

    public final boolean T2() {
        return this.f4867z;
    }

    public final void V2(boolean z2) {
        this.f4867z = z2;
    }

    public final void W2(Function0 function0, String str, Function0 function02, Function0 function03, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z2, String str2, Role role) {
        boolean z3;
        if (!Intrinsics.areEqual(this.f4864w, str)) {
            this.f4864w = str;
            SemanticsModifierNodeKt.b(this);
        }
        if ((this.f4865x == null) != (function02 == null)) {
            C2();
            SemanticsModifierNodeKt.b(this);
            z3 = true;
        } else {
            z3 = false;
        }
        this.f4865x = function02;
        if ((this.f4866y == null) != (function03 == null)) {
            z3 = true;
        }
        this.f4866y = function03;
        boolean z4 = F2() == z2 ? z3 : true;
        P2(mutableInteractionSource, indicationNodeFactory, z2, str2, role, function0);
        if (z4) {
            N2();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onReset() {
        super.onReset();
        U2();
    }

    @Override // androidx.compose.foundation.AbstractClickableNode
    public void z2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        if (this.f4865x != null) {
            SemanticsPropertiesKt.E(semanticsPropertyReceiver, this.f4864w, new Function0<Boolean>() { // from class: androidx.compose.foundation.CombinedClickableNode$applyAdditionalSemantics$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    Function0 function0 = this.f4870a.f4865x;
                    if (function0 != null) {
                        function0.invoke();
                    }
                    return Boolean.TRUE;
                }
            });
        }
    }

    private CombinedClickableNode(Function0 function0, String str, Function0 function02, Function0 function03, boolean z2, MutableInteractionSource mutableInteractionSource, IndicationNodeFactory indicationNodeFactory, boolean z3, String str2, Role role) {
        super(mutableInteractionSource, indicationNodeFactory, z3, str2, role, function0, null);
        this.f4864w = str;
        this.f4865x = function02;
        this.f4866y = function03;
        this.f4867z = z2;
        this.A = LongObjectMapKt.c();
        this.B = LongObjectMapKt.c();
    }
}
