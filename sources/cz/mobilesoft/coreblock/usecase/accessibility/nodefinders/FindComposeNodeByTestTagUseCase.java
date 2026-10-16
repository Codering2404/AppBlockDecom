package cz.mobilesoft.coreblock.usecase.accessibility.nodefinders;

import android.view.accessibility.AccessibilityNodeInfo;
import cz.mobilesoft.coreblock.usecase.UseCase;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class FindComposeNodeByTestTagUseCase extends UseCase<Params, AccessibilityNodeInfo> {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Params implements UseCase.Params {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AccessibilityNodeInfo f127533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f127534b;

        public Params(AccessibilityNodeInfo rootNode, String viewId) {
            Intrinsics.checkNotNullParameter(rootNode, "rootNode");
            Intrinsics.checkNotNullParameter(viewId, "viewId");
            this.f127533a = rootNode;
            this.f127534b = viewId;
        }

        public final AccessibilityNodeInfo a() {
            return this.f127533a;
        }

        public final String b() {
            return this.f127534b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Params)) {
                return false;
            }
            Params params = (Params) obj;
            return Intrinsics.areEqual(this.f127533a, params.f127533a) && Intrinsics.areEqual(this.f127534b, params.f127534b);
        }

        public int hashCode() {
            return (this.f127533a.hashCode() * 31) + this.f127534b.hashCode();
        }

        public String toString() {
            return "Params(rootNode=" + this.f127533a + ", viewId=" + this.f127534b + ")";
        }
    }

    public AccessibilityNodeInfo a(Params params) {
        Intrinsics.checkNotNullParameter(params, "params");
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.add(params.a());
        while (!arrayDeque.isEmpty()) {
            AccessibilityNodeInfo accessibilityNodeInfo = (AccessibilityNodeInfo) arrayDeque.removeFirst();
            String viewIdResourceName = accessibilityNodeInfo.getViewIdResourceName();
            if (viewIdResourceName != null && Intrinsics.areEqual(viewIdResourceName, params.b())) {
                return accessibilityNodeInfo;
            }
            int childCount = accessibilityNodeInfo.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i3);
                if (child != null) {
                    arrayDeque.add(child);
                }
            }
        }
        return null;
    }
}
