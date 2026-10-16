package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.view.MotionEvent;
import java.util.List;
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
public final class PointerEvent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List f26825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InternalPointerEvent f26826b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f26827c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f26828d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26829e;

    public PointerEvent(List list, InternalPointerEvent internalPointerEvent) {
        this.f26825a = list;
        this.f26826b = internalPointerEvent;
        MotionEvent motionEventG = g();
        this.f26827c = PointerButtons.a(motionEventG != null ? motionEventG.getButtonState() : 0);
        MotionEvent motionEventG2 = g();
        this.f26828d = PointerKeyboardModifiers.b(motionEventG2 != null ? motionEventG2.getMetaState() : 0);
        this.f26829e = a();
    }

    private final int a() {
        MotionEvent motionEventG = g();
        if (motionEventG == null) {
            List list = this.f26825a;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                PointerInputChange pointerInputChange = (PointerInputChange) list.get(i3);
                if (PointerEventKt.d(pointerInputChange)) {
                    return PointerEventType.f26835b.e();
                }
                if (PointerEventKt.b(pointerInputChange)) {
                    return PointerEventType.f26835b.d();
                }
            }
            return PointerEventType.f26835b.c();
        }
        int actionMasked = motionEventG.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    switch (actionMasked) {
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            return PointerEventType.f26835b.f();
                        case 9:
                            return PointerEventType.f26835b.a();
                        case 10:
                            return PointerEventType.f26835b.b();
                        default:
                            return PointerEventType.f26835b.g();
                    }
                }
                return PointerEventType.f26835b.c();
            }
            return PointerEventType.f26835b.e();
        }
        return PointerEventType.f26835b.d();
    }

    public final int b() {
        return this.f26827c;
    }

    public final List c() {
        return this.f26825a;
    }

    public final int d() {
        MotionEvent motionEventG;
        if (Build.VERSION.SDK_INT < 29 || (motionEventG = g()) == null) {
            return 0;
        }
        return motionEventG.getClassification();
    }

    public final InternalPointerEvent e() {
        return this.f26826b;
    }

    public final int f() {
        return this.f26828d;
    }

    public final MotionEvent g() {
        InternalPointerEvent internalPointerEvent = this.f26826b;
        if (internalPointerEvent != null) {
            return internalPointerEvent.c();
        }
        return null;
    }

    public final int h() {
        return this.f26829e;
    }

    public final void i(int i3) {
        this.f26829e = i3;
    }

    public PointerEvent(List list) {
        this(list, null);
    }
}
