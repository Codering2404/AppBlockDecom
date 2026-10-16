package androidx.media3.extractor.ts;

import android.util.SparseArray;
import androidx.media3.common.Format;
import androidx.media3.common.util.CodecSpecificDataUtil;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.extractor.ts.TsPayloadReader;
import com.google.common.collect.ImmutableList;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultTsPayloadReaderFactory implements TsPayloadReader.Factory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f47405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f47406b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public DefaultTsPayloadReaderFactory(int i3) {
        this(i3, ImmutableList.y());
    }

    private SeiReader c(TsPayloadReader.EsInfo esInfo) {
        return new SeiReader(e(esInfo), "video/mp2t");
    }

    private UserDataReader d(TsPayloadReader.EsInfo esInfo) {
        return new UserDataReader(e(esInfo), "video/mp2t");
    }

    private List e(TsPayloadReader.EsInfo esInfo) {
        String str;
        int i3;
        if (f(32)) {
            return this.f47406b;
        }
        ParsableByteArray parsableByteArray = new ParsableByteArray(esInfo.f47742e);
        List arrayList = this.f47406b;
        while (parsableByteArray.a() > 0) {
            int iH = parsableByteArray.H();
            int iF = parsableByteArray.f() + parsableByteArray.H();
            if (iH == 134) {
                arrayList = new ArrayList();
                int iH2 = parsableByteArray.H() & 31;
                for (int i4 = 0; i4 < iH2; i4++) {
                    String strE = parsableByteArray.E(3);
                    int iH3 = parsableByteArray.H();
                    boolean z2 = (iH3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
                    if (z2) {
                        i3 = iH3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i3 = 1;
                    }
                    byte bH = (byte) parsableByteArray.H();
                    parsableByteArray.X(1);
                    arrayList.add(new Format.Builder().u0(str).j0(strE).O(i3).g0(z2 ? CodecSpecificDataUtil.e((bH & 64) != 0) : null).N());
                }
            }
            parsableByteArray.W(iF);
        }
        return arrayList;
    }

    private boolean f(int i3) {
        return (i3 & this.f47405a) != 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
    @Override // androidx.media3.extractor.ts.TsPayloadReader.Factory
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public androidx.media3.extractor.ts.TsPayloadReader a(int r6, androidx.media3.extractor.ts.TsPayloadReader.EsInfo r7) {
        /*
            Method dump skipped, instruction units count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.extractor.ts.DefaultTsPayloadReaderFactory.a(int, androidx.media3.extractor.ts.TsPayloadReader$EsInfo):androidx.media3.extractor.ts.TsPayloadReader");
    }

    @Override // androidx.media3.extractor.ts.TsPayloadReader.Factory
    public SparseArray b() {
        return new SparseArray();
    }

    public DefaultTsPayloadReaderFactory(int i3, List list) {
        this.f47405a = i3;
        this.f47406b = list;
    }
}
