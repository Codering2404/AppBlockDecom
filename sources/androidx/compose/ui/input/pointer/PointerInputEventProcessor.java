package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import kotlin.Metadata;

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
public final class PointerInputEventProcessor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LayoutNode f26891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HitPathTracker f26892b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final PointerInputChangeEventProducer f26893c = new PointerInputChangeEventProducer();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final HitTestResult f26894d = new HitTestResult();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f26895e;

    public PointerInputEventProcessor(LayoutNode layoutNode) {
        this.f26891a = layoutNode;
        this.f26892b = new HitPathTracker(layoutNode.x());
    }

    public final void a() {
        this.f26892b.c();
    }

    public final int b(PointerInputEvent pointerInputEvent, PositionCalculator positionCalculator, boolean z2) {
        boolean z3;
        if (this.f26895e) {
            return PointerInputEventProcessorKt.a(false, false);
        }
        boolean z4 = true;
        try {
            this.f26895e = true;
            InternalPointerEvent internalPointerEventB = this.f26893c.b(pointerInputEvent, positionCalculator);
            int iR = internalPointerEventB.b().r();
            for (int i3 = 0; i3 < iR; i3++) {
                PointerInputChange pointerInputChange = (PointerInputChange) internalPointerEventB.b().s(i3);
                if (!pointerInputChange.i() && !pointerInputChange.l()) {
                }
                z3 = false;
                break;
            }
            z3 = true;
            int iR2 = internalPointerEventB.b().r();
            for (int i4 = 0; i4 < iR2; i4++) {
                PointerInputChange pointerInputChange2 = (PointerInputChange) internalPointerEventB.b().s(i4);
                if (z3 || PointerEventKt.b(pointerInputChange2)) {
                    LayoutNode.J0(this.f26891a, pointerInputChange2.h(), this.f26894d, pointerInputChange2.n(), false, 8, null);
                    if (!this.f26894d.isEmpty()) {
                        this.f26892b.b(pointerInputChange2.f(), this.f26894d, PointerEventKt.b(pointerInputChange2));
                        this.f26894d.clear();
                    }
                }
            }
            boolean zD = this.f26892b.d(internalPointerEventB, z2);
            if (internalPointerEventB.d()) {
                z4 = false;
            } else {
                int iR3 = internalPointerEventB.b().r();
                for (int i5 = 0; i5 < iR3; i5++) {
                    PointerInputChange pointerInputChange3 = (PointerInputChange) internalPointerEventB.b().s(i5);
                    if (PointerEventKt.k(pointerInputChange3) && pointerInputChange3.p()) {
                        break;
                    }
                }
                z4 = false;
            }
            int iA = PointerInputEventProcessorKt.a(zD, z4);
            this.f26895e = false;
            return iA;
        } catch (Throwable th) {
            this.f26895e = false;
            throw th;
        }
    }

    public final void c() {
        if (this.f26895e) {
            return;
        }
        this.f26893c.a();
        this.f26892b.e();
    }
}
