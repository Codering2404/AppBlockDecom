package androidx.constraintlayout.compose;

import android.util.Log;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLString;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class DimensionSymbol {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Dp f30540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f30541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f30542c;

    public /* synthetic */ DimensionSymbol(Dp dp, String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(dp, str, str2);
    }

    public final CLElement a() {
        Dp dp = this.f30540a;
        if (dp != null) {
            return new CLNumber(dp.l());
        }
        String str = this.f30541b;
        if (str != null) {
            return CLString.A(str);
        }
        Log.e("CCL", "DimensionDescription: Null value & symbol for " + this.f30542c + ". Using WrapContent.");
        return CLString.A("wrap");
    }

    public final boolean b() {
        return this.f30540a == null && this.f30541b == null;
    }

    private DimensionSymbol(Dp dp, String str, String str2) {
        this.f30540a = dp;
        this.f30541b = str;
        this.f30542c = str2;
    }
}
