package cz.mobilesoft.coreblock.dto.diagnostic;

import com.google.gson.annotations.SerializedName;
import java.util.List;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class StrictModeDTO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f96975a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f96976b = 8;

    @SerializedName("accessMethod")
    private final int accessMethod;

    @SerializedName("accessMethodName")
    private final String accessMethodName;

    @SerializedName("isStrictModeOn")
    private final boolean isStrictModeOn;

    @SerializedName("optionsMask")
    private final int optionsMask;

    @SerializedName("optionsNames")
    private final List<String> optionsNames;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final cz.mobilesoft.coreblock.dto.diagnostic.StrictModeDTO a(java.util.List r9, cz.mobilesoft.coreblock.enums.StrictModeAccessMethod r10, boolean r11) {
            /*
                r8 = this;
                java.lang.String r0 = "options"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
                java.lang.Iterable r9 = (java.lang.Iterable) r9
                java.util.Iterator r0 = r9.iterator()
                r1 = 0
                r3 = r1
            Ld:
                boolean r2 = r0.hasNext()
                if (r2 == 0) goto L1f
                java.lang.Object r2 = r0.next()
                cz.mobilesoft.coreblock.enums.StrictModeOption r2 = (cz.mobilesoft.coreblock.enums.StrictModeOption) r2
                int r2 = r2.getMask()
                r3 = r3 | r2
                goto Ld
            L1f:
                java.util.ArrayList r4 = new java.util.ArrayList
                r0 = 10
                int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r9, r0)
                r4.<init>(r0)
                java.util.Iterator r9 = r9.iterator()
            L2e:
                boolean r0 = r9.hasNext()
                java.lang.String r2 = "toLowerCase(...)"
                if (r0 == 0) goto L4d
                java.lang.Object r0 = r9.next()
                cz.mobilesoft.coreblock.enums.StrictModeOption r0 = (cz.mobilesoft.coreblock.enums.StrictModeOption) r0
                java.lang.String r0 = r0.name()
                java.util.Locale r5 = java.util.Locale.ROOT
                java.lang.String r0 = r0.toLowerCase(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
                r4.add(r0)
                goto L2e
            L4d:
                if (r10 == 0) goto L53
                int r1 = r10.getMask()
            L53:
                r5 = r1
                if (r10 == 0) goto L6a
                java.lang.String r9 = r10.name()
                if (r9 == 0) goto L6a
                java.util.Locale r10 = java.util.Locale.ROOT
                java.lang.String r9 = r9.toLowerCase(r10)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
                if (r9 != 0) goto L68
                goto L6a
            L68:
                r6 = r9
                goto L6d
            L6a:
                java.lang.String r9 = "unset"
                goto L68
            L6d:
                cz.mobilesoft.coreblock.dto.diagnostic.StrictModeDTO r2 = new cz.mobilesoft.coreblock.dto.diagnostic.StrictModeDTO
                r7 = r11
                r2.<init>(r3, r4, r5, r6, r7)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.dto.diagnostic.StrictModeDTO.Companion.a(java.util.List, cz.mobilesoft.coreblock.enums.StrictModeAccessMethod, boolean):cz.mobilesoft.coreblock.dto.diagnostic.StrictModeDTO");
        }

        private Companion() {
        }
    }

    public StrictModeDTO(int i3, List optionsNames, int i4, String accessMethodName, boolean z2) {
        Intrinsics.checkNotNullParameter(optionsNames, "optionsNames");
        Intrinsics.checkNotNullParameter(accessMethodName, "accessMethodName");
        this.optionsMask = i3;
        this.optionsNames = optionsNames;
        this.accessMethod = i4;
        this.accessMethodName = accessMethodName;
        this.isStrictModeOn = z2;
    }

    public final int a() {
        return this.accessMethod;
    }

    public final String b() {
        return this.accessMethodName;
    }

    public final int c() {
        return this.optionsMask;
    }

    public final List d() {
        return this.optionsNames;
    }

    public final boolean e() {
        return this.isStrictModeOn;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StrictModeDTO)) {
            return false;
        }
        StrictModeDTO strictModeDTO = (StrictModeDTO) obj;
        return this.optionsMask == strictModeDTO.optionsMask && Intrinsics.areEqual(this.optionsNames, strictModeDTO.optionsNames) && this.accessMethod == strictModeDTO.accessMethod && Intrinsics.areEqual(this.accessMethodName, strictModeDTO.accessMethodName) && this.isStrictModeOn == strictModeDTO.isStrictModeOn;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.optionsMask) * 31) + this.optionsNames.hashCode()) * 31) + Integer.hashCode(this.accessMethod)) * 31) + this.accessMethodName.hashCode()) * 31) + Boolean.hashCode(this.isStrictModeOn);
    }

    public String toString() {
        return "StrictModeDTO(optionsMask=" + this.optionsMask + ", optionsNames=" + this.optionsNames + ", accessMethod=" + this.accessMethod + ", accessMethodName=" + this.accessMethodName + ", isStrictModeOn=" + this.isStrictModeOn + ")";
    }
}
