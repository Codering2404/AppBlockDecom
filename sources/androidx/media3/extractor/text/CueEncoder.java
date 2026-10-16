package androidx.media3.extractor.text;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.text.Cue;
import androidx.media3.common.util.BundleCollectionUtil;
import com.google.common.base.Function;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class CueEncoder {
    public byte[] a(List list, long j3) {
        ArrayList<? extends Parcelable> arrayListB = BundleCollectionUtil.b(list, new Function() { // from class: androidx.media3.extractor.text.b
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return ((Cue) obj).d();
            }
        });
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", arrayListB);
        bundle.putLong("d", j3);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeBundle(bundle);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }
}
