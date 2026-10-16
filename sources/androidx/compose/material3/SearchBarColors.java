package androidx.compose.material3;

import androidx.compose.ui.graphics.Color;
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
public final class SearchBarColors {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f19464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f19465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TextFieldColors f19466c;

    public /* synthetic */ SearchBarColors(long j3, long j4, TextFieldColors textFieldColors, DefaultConstructorMarker defaultConstructorMarker) {
        this(j3, j4, textFieldColors);
    }

    public final long a() {
        return this.f19464a;
    }

    public final long b() {
        return this.f19465b;
    }

    public final TextFieldColors c() {
        return this.f19466c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SearchBarColors)) {
            return false;
        }
        SearchBarColors searchBarColors = (SearchBarColors) obj;
        return Color.t(this.f19464a, searchBarColors.f19464a) && Color.t(this.f19465b, searchBarColors.f19465b) && Intrinsics.areEqual(this.f19466c, searchBarColors.f19466c);
    }

    public int hashCode() {
        return (((Color.z(this.f19464a) * 31) + Color.z(this.f19465b)) * 31) + this.f19466c.hashCode();
    }

    private SearchBarColors(long j3, long j4, TextFieldColors textFieldColors) {
        this.f19464a = j3;
        this.f19465b = j4;
        this.f19466c = textFieldColors;
    }
}
