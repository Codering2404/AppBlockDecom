package androidx.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BundleCollectionUtil;
import com.google.common.base.Function;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CueDecoder {
    public CuesWithTiming a(long j3, byte[] bArr, int i3, int i4) {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, i3, i4);
        parcelObtain.setDataPosition(0);
        Bundle bundle = parcelObtain.readBundle(Bundle.class.getClassLoader());
        parcelObtain.recycle();
        return new CuesWithTiming(BundleCollectionUtil.a(new Function() { // from class: androidx.media3.extractor.text.a
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Cue.b((Bundle) obj);
            }
        }, (ArrayList) Assertions.e(bundle.getParcelableArrayList("c"))), j3, bundle.getLong("d"));
    }
}
