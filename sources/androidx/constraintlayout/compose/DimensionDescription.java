package androidx.constraintlayout.compose;

import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.compose.Dimension;
import androidx.constraintlayout.core.parser.CLElement;
import androidx.constraintlayout.core.parser.CLObject;
import com.applovin.sdk.AppLovinMediationProvider;
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
public final class DimensionDescription implements Dimension.Coercible, Dimension.MinCoercible, Dimension.MaxCoercible, Dimension {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final DimensionSymbol f30537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final DimensionSymbol f30538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final DimensionSymbol f30539d;

    public /* synthetic */ DimensionDescription(float f3, DefaultConstructorMarker defaultConstructorMarker) {
        this(f3);
    }

    public final CLElement a() {
        if (this.f30538c.b() && this.f30539d.b()) {
            return this.f30537b.a();
        }
        CLObject cLObject = new CLObject(new char[0]);
        if (!this.f30538c.b()) {
            cLObject.W("min", this.f30538c.a());
        }
        if (!this.f30539d.b()) {
            cLObject.W(AppLovinMediationProvider.MAX, this.f30539d.a());
        }
        cLObject.W("value", this.f30537b.a());
        return cLObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private DimensionDescription(Dp dp, String str) {
        this.f30537b = new DimensionSymbol(dp, str, "base", null);
        this.f30538c = new DimensionSymbol(0 == true ? 1 : 0, 0 == true ? 1 : 0, "min", 0 == true ? 1 : 0);
        this.f30539d = new DimensionSymbol(0 == true ? 1 : 0, 0 == true ? 1 : 0, AppLovinMediationProvider.MAX, 0 == true ? 1 : 0);
    }

    private DimensionDescription(float f3) {
        this(Dp.d(f3), (String) null);
    }

    public DimensionDescription(String str) {
        this((Dp) null, str);
    }
}
