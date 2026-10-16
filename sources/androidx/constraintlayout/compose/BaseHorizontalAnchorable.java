package androidx.constraintlayout.compose;

import androidx.constraintlayout.compose.ConstraintLayoutBaseScope;
import androidx.constraintlayout.core.parser.CLArray;
import androidx.constraintlayout.core.parser.CLNumber;
import androidx.constraintlayout.core.parser.CLObject;
import androidx.constraintlayout.core.parser.CLString;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class BaseHorizontalAnchorable implements HorizontalAnchorable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CLObject f30342a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f30343b;

    public BaseHorizontalAnchorable(CLObject cLObject, int i3) {
        this.f30342a = cLObject;
        this.f30343b = AnchorFunctions.f30332a.a(i3);
    }

    @Override // androidx.constraintlayout.compose.HorizontalAnchorable
    public final void b(ConstraintLayoutBaseScope.HorizontalAnchor horizontalAnchor, float f3, float f4) {
        String strA = AnchorFunctions.f30332a.a(horizontalAnchor.b());
        CLArray cLArray = new CLArray(new char[0]);
        cLArray.z(CLString.A(horizontalAnchor.a().toString()));
        cLArray.z(CLString.A(strA));
        cLArray.z(new CLNumber(f3));
        cLArray.z(new CLNumber(f4));
        this.f30342a.W(this.f30343b, cLArray);
    }
}
