package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public abstract class LinkAnnotation implements AnnotatedString.Annotation {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Clickable extends LinkAnnotation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28704a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextLinkStyles f28705b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkInteractionListener f28706c;

        public Clickable(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            super(null);
            this.f28704a = str;
            this.f28705b = textLinkStyles;
            this.f28706c = linkInteractionListener;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener a() {
            return this.f28706c;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public TextLinkStyles b() {
            return this.f28705b;
        }

        public final String c() {
            return this.f28704a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Clickable)) {
                return false;
            }
            Clickable clickable = (Clickable) obj;
            return Intrinsics.areEqual(this.f28704a, clickable.f28704a) && Intrinsics.areEqual(b(), clickable.b()) && Intrinsics.areEqual(a(), clickable.a());
        }

        public int hashCode() {
            int iHashCode = this.f28704a.hashCode() * 31;
            TextLinkStyles textLinkStylesB = b();
            int iHashCode2 = (iHashCode + (textLinkStylesB != null ? textLinkStylesB.hashCode() : 0)) * 31;
            LinkInteractionListener linkInteractionListenerA = a();
            return iHashCode2 + (linkInteractionListenerA != null ? linkInteractionListenerA.hashCode() : 0);
        }

        public String toString() {
            return "LinkAnnotation.Clickable(tag=" + this.f28704a + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Url extends LinkAnnotation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f28707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TextLinkStyles f28708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final LinkInteractionListener f28709c;

        public /* synthetic */ Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? null : textLinkStyles, (i3 & 4) != 0 ? null : linkInteractionListener);
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public LinkInteractionListener a() {
            return this.f28709c;
        }

        @Override // androidx.compose.ui.text.LinkAnnotation
        public TextLinkStyles b() {
            return this.f28708b;
        }

        public final String c() {
            return this.f28707a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Url)) {
                return false;
            }
            Url url = (Url) obj;
            return Intrinsics.areEqual(this.f28707a, url.f28707a) && Intrinsics.areEqual(b(), url.b()) && Intrinsics.areEqual(a(), url.a());
        }

        public int hashCode() {
            int iHashCode = this.f28707a.hashCode() * 31;
            TextLinkStyles textLinkStylesB = b();
            int iHashCode2 = (iHashCode + (textLinkStylesB != null ? textLinkStylesB.hashCode() : 0)) * 31;
            LinkInteractionListener linkInteractionListenerA = a();
            return iHashCode2 + (linkInteractionListenerA != null ? linkInteractionListenerA.hashCode() : 0);
        }

        public String toString() {
            return "LinkAnnotation.Url(url=" + this.f28707a + ')';
        }

        public Url(String str, TextLinkStyles textLinkStyles, LinkInteractionListener linkInteractionListener) {
            super(null);
            this.f28707a = str;
            this.f28708b = textLinkStyles;
            this.f28709c = linkInteractionListener;
        }
    }

    public /* synthetic */ LinkAnnotation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract LinkInteractionListener a();

    public abstract TextLinkStyles b();

    private LinkAnnotation() {
    }
}
