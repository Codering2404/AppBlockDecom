package androidx.compose.ui.node;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.ui.internal.InlineClassHelperKt;
import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
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
public final class DepthSortedSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27311a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableObjectIntMap f27312b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TreeSet f27313c = new TreeSet(DepthSortedSetKt.f27314a);

    public DepthSortedSet(boolean z2) {
        this.f27311a = z2;
    }

    private final MutableObjectIntMap f() {
        if (this.f27312b == null) {
            this.f27312b = ObjectIntMapKt.b();
        }
        MutableObjectIntMap mutableObjectIntMap = this.f27312b;
        Intrinsics.checkNotNull(mutableObjectIntMap);
        return mutableObjectIntMap;
    }

    public final void a(LayoutNode layoutNode) {
        if (!layoutNode.m()) {
            InlineClassHelperKt.c("DepthSortedSet.add called on an unattached node");
        }
        if (this.f27311a) {
            MutableObjectIntMap mutableObjectIntMapF = f();
            int iE = mutableObjectIntMapF.e(layoutNode, Api.BaseClientBuilder.API_PRIORITY_OTHER);
            if (iE == Integer.MAX_VALUE) {
                mutableObjectIntMapF.u(layoutNode, layoutNode.V());
            } else {
                if (!(iE == layoutNode.V())) {
                    InlineClassHelperKt.c("invalid node depth");
                }
            }
        }
        this.f27313c.add(layoutNode);
    }

    public final boolean b(LayoutNode layoutNode) {
        boolean zContains = this.f27313c.contains(layoutNode);
        if (this.f27311a) {
            if (!(zContains == f().a(layoutNode))) {
                InlineClassHelperKt.c("inconsistency in TreeSet");
            }
        }
        return zContains;
    }

    public final boolean c() {
        return this.f27313c.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LayoutNode d() {
        LayoutNode layoutNode = (LayoutNode) this.f27313c.first();
        e(layoutNode);
        return layoutNode;
    }

    public final boolean e(LayoutNode layoutNode) {
        if (!layoutNode.m()) {
            InlineClassHelperKt.c("DepthSortedSet.remove called on an unattached node");
        }
        boolean zRemove = this.f27313c.remove(layoutNode);
        if (this.f27311a) {
            MutableObjectIntMap mutableObjectIntMapF = f();
            if (mutableObjectIntMapF.a(layoutNode)) {
                int iC = mutableObjectIntMapF.c(layoutNode);
                mutableObjectIntMapF.r(layoutNode);
                if (!(iC == (zRemove ? layoutNode.V() : Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
                    InlineClassHelperKt.c("invalid node depth");
                }
            }
        }
        return zRemove;
    }

    public String toString() {
        return this.f27313c.toString();
    }
}
