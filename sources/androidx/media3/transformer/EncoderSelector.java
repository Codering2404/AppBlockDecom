package androidx.media3.transformer;

import android.media.MediaCodecInfo;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public interface EncoderSelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EncoderSelector f48139a = new EncoderSelector() { // from class: androidx.media3.transformer.l1
        @Override // androidx.media3.transformer.EncoderSelector
        public final ImmutableList b(String str) {
            return EncoderSelector.c(str);
        }
    };

    static /* synthetic */ ImmutableList c(final String str) {
        ImmutableList immutableListH = EncoderUtil.h(str);
        ImmutableList immutableListS = ImmutableList.s(Iterables.e(immutableListH, new Predicate() { // from class: androidx.media3.transformer.m1
            @Override // com.google.common.base.Predicate
            public final boolean apply(Object obj) {
                return EncoderUtil.m((MediaCodecInfo) obj, str);
            }
        }));
        return immutableListS.isEmpty() ? immutableListH : immutableListS;
    }

    ImmutableList b(String str);
}
