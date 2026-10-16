package androidx.compose.ui.text;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public final class TextLinkStyles {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SpanStyle f28909a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SpanStyle f28910b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SpanStyle f28911c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final SpanStyle f28912d;

    public TextLinkStyles(SpanStyle spanStyle, SpanStyle spanStyle2, SpanStyle spanStyle3, SpanStyle spanStyle4) {
        this.f28909a = spanStyle;
        this.f28910b = spanStyle2;
        this.f28911c = spanStyle3;
        this.f28912d = spanStyle4;
    }

    public final SpanStyle a() {
        return this.f28910b;
    }

    public final SpanStyle b() {
        return this.f28911c;
    }

    public final SpanStyle c() {
        return this.f28912d;
    }

    public final SpanStyle d() {
        return this.f28909a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof TextLinkStyles)) {
            return false;
        }
        TextLinkStyles textLinkStyles = (TextLinkStyles) obj;
        return Intrinsics.areEqual(this.f28909a, textLinkStyles.f28909a) && Intrinsics.areEqual(this.f28910b, textLinkStyles.f28910b) && Intrinsics.areEqual(this.f28911c, textLinkStyles.f28911c) && Intrinsics.areEqual(this.f28912d, textLinkStyles.f28912d);
    }

    public int hashCode() {
        SpanStyle spanStyle = this.f28909a;
        int iHashCode = (spanStyle != null ? spanStyle.hashCode() : 0) * 31;
        SpanStyle spanStyle2 = this.f28910b;
        int iHashCode2 = (iHashCode + (spanStyle2 != null ? spanStyle2.hashCode() : 0)) * 31;
        SpanStyle spanStyle3 = this.f28911c;
        int iHashCode3 = (iHashCode2 + (spanStyle3 != null ? spanStyle3.hashCode() : 0)) * 31;
        SpanStyle spanStyle4 = this.f28912d;
        return iHashCode3 + (spanStyle4 != null ? spanStyle4.hashCode() : 0);
    }

    public /* synthetic */ TextLinkStyles(SpanStyle spanStyle, SpanStyle spanStyle2, SpanStyle spanStyle3, SpanStyle spanStyle4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : spanStyle, (i3 & 2) != 0 ? null : spanStyle2, (i3 & 4) != 0 ? null : spanStyle3, (i3 & 8) != 0 ? null : spanStyle4);
    }
}
