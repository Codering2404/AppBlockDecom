package androidx.media3.extractor;

import androidx.media3.common.Metadata;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.metadata.id3.CommentFrame;
import androidx.media3.extractor.metadata.id3.InternalFrame;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class GaplessInfoHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f46174c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f46175a = -1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f46176b = -1;

    private boolean b(String str) {
        Matcher matcher = f46174c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i3 = Integer.parseInt((String) Util.k(matcher.group(1)), 16);
            int i4 = Integer.parseInt((String) Util.k(matcher.group(2)), 16);
            if (i3 <= 0 && i4 <= 0) {
                return false;
            }
            this.f46175a = i3;
            this.f46176b = i4;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public boolean a() {
        return (this.f46175a == -1 || this.f46176b == -1) ? false : true;
    }

    public boolean c(Metadata metadata) {
        for (int i3 = 0; i3 < metadata.e(); i3++) {
            Metadata.Entry entryD = metadata.d(i3);
            if (entryD instanceof CommentFrame) {
                CommentFrame commentFrame = (CommentFrame) entryD;
                if ("iTunSMPB".equals(commentFrame.f46464c) && b(commentFrame.f46465d)) {
                    return true;
                }
            } else if (entryD instanceof InternalFrame) {
                InternalFrame internalFrame = (InternalFrame) entryD;
                if ("com.apple.iTunes".equals(internalFrame.f46477b) && "iTunSMPB".equals(internalFrame.f46478c) && b(internalFrame.f46479d)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
