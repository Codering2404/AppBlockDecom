package androidx.media3.extractor.metadata.icy;

import androidx.media3.common.Metadata;
import androidx.media3.extractor.metadata.MetadataInputBuffer;
import androidx.media3.extractor.metadata.SimpleMetadataDecoder;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class IcyDecoder extends SimpleMetadataDecoder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f46435c = Pattern.compile("(.+?)='(.*?)';", 32);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CharsetDecoder f46436a = StandardCharsets.UTF_8.newDecoder();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final CharsetDecoder f46437b = StandardCharsets.ISO_8859_1.newDecoder();

    private String c(ByteBuffer byteBuffer) {
        try {
            return this.f46436a.decode(byteBuffer).toString();
        } catch (CharacterCodingException unused) {
            try {
                String string = this.f46437b.decode(byteBuffer).toString();
                this.f46437b.reset();
                byteBuffer.rewind();
                return string;
            } catch (CharacterCodingException unused2) {
                this.f46437b.reset();
                byteBuffer.rewind();
                return null;
            } catch (Throwable th) {
                this.f46437b.reset();
                byteBuffer.rewind();
                throw th;
            }
        } finally {
            this.f46436a.reset();
            byteBuffer.rewind();
        }
    }

    @Override // androidx.media3.extractor.metadata.SimpleMetadataDecoder
    protected Metadata b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        String strC = c(byteBuffer);
        byte[] bArr = new byte[byteBuffer.limit()];
        byteBuffer.get(bArr);
        String str = null;
        if (strC == null) {
            return new Metadata(new IcyInfo(bArr, null, null));
        }
        Matcher matcher = f46435c.matcher(strC);
        String str2 = null;
        for (int iEnd = 0; matcher.find(iEnd); iEnd = matcher.end()) {
            String strGroup = matcher.group(1);
            String strGroup2 = matcher.group(2);
            if (strGroup != null) {
                String strE = Ascii.e(strGroup);
                strE.getClass();
                if (strE.equals("streamurl")) {
                    str2 = strGroup2;
                } else if (strE.equals("streamtitle")) {
                    str = strGroup2;
                }
            }
        }
        return new Metadata(new IcyInfo(bArr, str, str2));
    }
}
