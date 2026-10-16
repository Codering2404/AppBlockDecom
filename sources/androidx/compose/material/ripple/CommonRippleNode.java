package androidx.compose.material.ripple;

import androidx.collection.MutableScatterMap;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorProducer;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CommonRippleNode extends RippleNode {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableScatterMap f15336m;

    public /* synthetic */ CommonRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, Function0 function0, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, z2, f3, colorProducer, function0);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        this.f15336m.k();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    @Override // androidx.compose.material.ripple.RippleNode
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void r2(androidx.compose.foundation.interaction.PressInteraction.Press r18, long r19, float r21) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            androidx.collection.MutableScatterMap r2 = r0.f15336m
            java.lang.Object[] r3 = r2.f3109b
            java.lang.Object[] r4 = r2.f3110c
            long[] r2 = r2.f3108a
            int r5 = r2.length
            int r5 = r5 + (-2)
            if (r5 < 0) goto L51
            r6 = 0
            r7 = r6
        L13:
            r8 = r2[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L4c
            int r10 = r7 - r5
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r6
        L2d:
            if (r12 >= r10) goto L4a
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L46
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r3[r13]
            r13 = r4[r13]
            androidx.compose.material.ripple.RippleAnimation r13 = (androidx.compose.material.ripple.RippleAnimation) r13
            androidx.compose.foundation.interaction.PressInteraction$Press r14 = (androidx.compose.foundation.interaction.PressInteraction.Press) r14
            r13.h()
        L46:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L2d
        L4a:
            if (r10 != r11) goto L51
        L4c:
            if (r7 == r5) goto L51
            int r7 = r7 + 1
            goto L13
        L51:
            boolean r2 = r0.t2()
            r3 = 0
            if (r2 == 0) goto L61
            long r4 = r1.a()
            androidx.compose.ui.geometry.Offset r2 = androidx.compose.ui.geometry.Offset.d(r4)
            goto L62
        L61:
            r2 = r3
        L62:
            androidx.compose.material.ripple.RippleAnimation r4 = new androidx.compose.material.ripple.RippleAnimation
            boolean r5 = r0.t2()
            r6 = r21
            r4.<init>(r2, r6, r5, r3)
            androidx.collection.MutableScatterMap r2 = r0.f15336m
            r2.x(r1, r4)
            kotlinx.coroutines.CoroutineScope r5 = r0.getCoroutineScope()
            androidx.compose.material.ripple.CommonRippleNode$addRipple$2 r8 = new androidx.compose.material.ripple.CommonRippleNode$addRipple$2
            r8.<init>(r4, r0, r1, r3)
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            kotlinx.coroutines.BuildersKt.d(r5, r6, r7, r8, r9, r10)
            androidx.compose.ui.node.DrawModifierNodeKt.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ripple.CommonRippleNode.r2(androidx.compose.foundation.interaction.PressInteraction$Press, long, float):void");
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void s2(DrawScope drawScope) {
        float f3;
        int i3;
        int i4;
        int i5;
        float f4;
        float fD = ((RippleAlpha) u2().invoke()).d();
        if (fD == 0.0f) {
            return;
        }
        MutableScatterMap mutableScatterMap = this.f15336m;
        Object[] objArr = mutableScatterMap.f3109b;
        Object[] objArr2 = mutableScatterMap.f3110c;
        long[] jArr = mutableScatterMap.f3108a;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i6 = 0;
        while (true) {
            long j3 = jArr[i6];
            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i7 = 8;
                int i8 = 8 - ((~(i6 - length)) >>> 31);
                long j4 = j3;
                int i9 = 0;
                while (i9 < i8) {
                    if ((j4 & 255) < 128) {
                        int i10 = (i6 << 3) + i9;
                        i3 = i9;
                        i4 = i8;
                        i5 = i7;
                        f4 = fD;
                        ((RippleAnimation) objArr2[i10]).e(drawScope, Color.r(v2(), fD, 0.0f, 0.0f, 0.0f, 14, null));
                    } else {
                        i3 = i9;
                        i4 = i8;
                        i5 = i7;
                        f4 = fD;
                    }
                    j4 >>= i5;
                    i9 = i3 + 1;
                    fD = f4;
                    i8 = i4;
                    i7 = i5;
                }
                int i11 = i8;
                f3 = fD;
                if (i11 != i7) {
                    return;
                }
            } else {
                f3 = fD;
            }
            if (i6 == length) {
                return;
            }
            i6++;
            fD = f3;
        }
    }

    @Override // androidx.compose.material.ripple.RippleNode
    public void y2(PressInteraction.Press press) {
        RippleAnimation rippleAnimation = (RippleAnimation) this.f15336m.e(press);
        if (rippleAnimation != null) {
            rippleAnimation.h();
        }
    }

    private CommonRippleNode(InteractionSource interactionSource, boolean z2, float f3, ColorProducer colorProducer, Function0 function0) {
        super(interactionSource, z2, f3, colorProducer, function0, null);
        this.f15336m = new MutableScatterMap(0, 1, null);
    }
}
