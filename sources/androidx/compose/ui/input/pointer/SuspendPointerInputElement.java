package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.ModifierNodeElement;
import androidx.compose.ui.platform.InspectorInfo;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class SuspendPointerInputElement extends ModifierNodeElement<SuspendingPointerInputModifierNodeImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f26935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f26936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object[] f26937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PointerInputEventHandler f26938d;

    public /* synthetic */ SuspendPointerInputElement(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : obj, (i3 & 2) != 0 ? null : obj2, (i3 & 4) != 0 ? null : objArr, pointerInputEventHandler);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public SuspendingPointerInputModifierNodeImpl create() {
        return new SuspendingPointerInputModifierNodeImpl(this.f26935a, this.f26936b, this.f26937c, this.f26938d);
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(SuspendingPointerInputModifierNodeImpl suspendingPointerInputModifierNodeImpl) {
        suspendingPointerInputModifierNodeImpl.t2(this.f26935a, this.f26936b, this.f26937c, this.f26938d);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SuspendPointerInputElement)) {
            return false;
        }
        SuspendPointerInputElement suspendPointerInputElement = (SuspendPointerInputElement) obj;
        if (!Intrinsics.areEqual(this.f26935a, suspendPointerInputElement.f26935a) || !Intrinsics.areEqual(this.f26936b, suspendPointerInputElement.f26936b)) {
            return false;
        }
        Object[] objArr = this.f26937c;
        if (objArr != null) {
            Object[] objArr2 = suspendPointerInputElement.f26937c;
            if (objArr2 == null || !Arrays.equals(objArr, objArr2)) {
                return false;
            }
        } else if (suspendPointerInputElement.f26937c != null) {
            return false;
        }
        return this.f26938d == suspendPointerInputElement.f26938d;
    }

    public int hashCode() {
        Object obj = this.f26935a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        Object obj2 = this.f26936b;
        int iHashCode2 = (iHashCode + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object[] objArr = this.f26937c;
        return ((iHashCode2 + (objArr != null ? Arrays.hashCode(objArr) : 0)) * 31) + this.f26938d.hashCode();
    }

    @Override // androidx.compose.ui.node.ModifierNodeElement
    public void inspectableProperties(InspectorInfo inspectorInfo) {
        inspectorInfo.d("pointerInput");
        inspectorInfo.b().c("key1", this.f26935a);
        inspectorInfo.b().c("key2", this.f26936b);
        inspectorInfo.b().c("keys", this.f26937c);
        inspectorInfo.b().c("pointerInputEventHandler", this.f26938d);
    }

    public SuspendPointerInputElement(Object obj, Object obj2, Object[] objArr, PointerInputEventHandler pointerInputEventHandler) {
        this.f26935a = obj;
        this.f26936b = obj2;
        this.f26937c = objArr;
        this.f26938d = pointerInputEventHandler;
    }
}
