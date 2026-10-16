package androidx.room;

import com.google.android.gms.common.api.Api;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class AmbiguousColumnResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AmbiguousColumnResolver f52085a = new AmbiguousColumnResolver();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Match {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ResultColumn {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f52086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f52087b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ResultColumn)) {
                return false;
            }
            ResultColumn resultColumn = (ResultColumn) obj;
            return Intrinsics.areEqual(this.f52086a, resultColumn.f52086a) && this.f52087b == resultColumn.f52087b;
        }

        public int hashCode() {
            return (this.f52086a.hashCode() * 31) + Integer.hashCode(this.f52087b);
        }

        public String toString() {
            return "ResultColumn(name=" + this.f52086a + ", index=" + this.f52087b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Solution implements Comparable<Solution> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Companion f52088d = new Companion(null);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final Solution f52089f = new Solution(CollectionsKt.emptyList(), Api.BaseClientBuilder.API_PRIORITY_OTHER, Api.BaseClientBuilder.API_PRIORITY_OTHER);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f52090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f52091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f52092c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }

        public Solution(List matches, int i3, int i4) {
            Intrinsics.checkNotNullParameter(matches, "matches");
            this.f52090a = matches;
            this.f52091b = i3;
            this.f52092c = i4;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Solution other) {
            Intrinsics.checkNotNullParameter(other, "other");
            int iCompare = Intrinsics.compare(this.f52092c, other.f52092c);
            return iCompare != 0 ? iCompare : Intrinsics.compare(this.f52091b, other.f52091b);
        }
    }

    private AmbiguousColumnResolver() {
    }
}
