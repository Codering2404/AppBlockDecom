package androidx.compose.ui.text;

import android.text.Editable;
import java.util.ArrayList;
import kotlin.Metadata;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

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
final class AnnotationContentHandler implements ContentHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ContentHandler f28659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Editable f28660b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f28661c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private BulletSpanWithLevel f28662d;

    public AnnotationContentHandler(ContentHandler contentHandler, Editable editable) {
        this.f28659a = contentHandler;
        this.f28660b = editable;
    }

    private final void a() {
        BulletSpanWithLevel bulletSpanWithLevel = this.f28662d;
        if (bulletSpanWithLevel != null) {
            this.f28660b.setSpan(bulletSpanWithLevel, bulletSpanWithLevel.c(), this.f28660b.length(), 33);
        }
        this.f28662d = null;
    }

    private final void b() {
        Editable editable = this.f28660b;
        Object[] spans = editable.getSpans(0, editable.length(), AnnotationSpan.class);
        ArrayList arrayList = new ArrayList();
        for (Object obj : spans) {
            if (this.f28660b.getSpanFlags((AnnotationSpan) obj) == 17) {
                arrayList.add(obj);
            }
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            AnnotationSpan annotationSpan = (AnnotationSpan) arrayList.get(i3);
            int spanStart = this.f28660b.getSpanStart(annotationSpan);
            int length = this.f28660b.length();
            this.f28660b.removeSpan(annotationSpan);
            if (spanStart != length) {
                this.f28660b.setSpan(annotationSpan, spanStart, length, 33);
            }
        }
    }

    private final void c(Attributes attributes) {
        int length = attributes.getLength();
        for (int i3 = 0; i3 < length; i3++) {
            String localName = attributes.getLocalName(i3);
            if (localName == null) {
                localName = "";
            }
            String value = attributes.getValue(i3);
            String str = value != null ? value : "";
            if (localName.length() > 0 && str.length() > 0) {
                int length2 = this.f28660b.length();
                this.f28660b.setSpan(new AnnotationSpan(localName, str), length2, length2, 17);
            }
        }
    }

    private final void d() {
        a();
    }

    private final void e() {
        a();
        this.f28662d = new BulletSpanWithLevel(BulletKt.a(), this.f28661c, this.f28660b.length());
    }

    private final void f() {
        a();
        this.f28661c--;
    }

    private final void g() {
        a();
        this.f28661c++;
    }

    @Override // org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i3, int i4) throws SAXException {
        this.f28659a.characters(cArr, i3, i4);
    }

    @Override // org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        this.f28659a.endDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (str2 != null) {
            int iHashCode = str2.hashCode();
            if (iHashCode != -1555043537) {
                if (iHashCode != 3453) {
                    if (iHashCode == 3735 && str2.equals("ul")) {
                        f();
                        return;
                    }
                } else if (str2.equals("li")) {
                    d();
                    return;
                }
            } else if (str2.equals("annotation")) {
                b();
                return;
            }
        }
        this.f28659a.endElement(str, str2, str3);
    }

    @Override // org.xml.sax.ContentHandler
    public void endPrefixMapping(String str) throws SAXException {
        this.f28659a.endPrefixMapping(str);
    }

    @Override // org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i3, int i4) throws SAXException {
        this.f28659a.ignorableWhitespace(cArr, i3, i4);
    }

    @Override // org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        this.f28659a.processingInstruction(str, str2);
    }

    @Override // org.xml.sax.ContentHandler
    public void setDocumentLocator(Locator locator) {
        this.f28659a.setDocumentLocator(locator);
    }

    @Override // org.xml.sax.ContentHandler
    public void skippedEntity(String str) throws SAXException {
        this.f28659a.skippedEntity(str);
    }

    @Override // org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        this.f28659a.startDocument();
    }

    @Override // org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        if (str2 != null) {
            int iHashCode = str2.hashCode();
            if (iHashCode != -1555043537) {
                if (iHashCode != 3453) {
                    if (iHashCode == 3735 && str2.equals("ul")) {
                        g();
                        return;
                    }
                } else if (str2.equals("li")) {
                    e();
                    return;
                }
            } else if (str2.equals("annotation")) {
                if (attributes != null) {
                    c(attributes);
                    return;
                }
                return;
            }
        }
        this.f28659a.startElement(str, str2, str3, attributes);
    }

    @Override // org.xml.sax.ContentHandler
    public void startPrefixMapping(String str, String str2) throws SAXException {
        this.f28659a.startPrefixMapping(str, str2);
    }
}
