package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.ParserException;
import com.google.common.collect.ImmutableList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class UnrecognizedInputFormatException extends ParserException {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Uri f44990c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ImmutableList f44991d;

    public UnrecognizedInputFormatException(String str, Uri uri, List list) {
        super(str, null, false, 1);
        this.f44990c = uri;
        this.f44991d = ImmutableList.t(list);
    }
}
