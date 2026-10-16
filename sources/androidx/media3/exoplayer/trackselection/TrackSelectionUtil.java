package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.common.Tracks;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.MappingTrackSelector;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectionUtil {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface AdaptiveTrackSelectionFactory {
        ExoTrackSelection a(ExoTrackSelection.Definition definition);
    }

    public static Tracks a(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, TrackSelection[] trackSelectionArr) {
        List[] listArr = new List[trackSelectionArr.length];
        for (int i3 = 0; i3 < trackSelectionArr.length; i3++) {
            TrackSelection trackSelection = trackSelectionArr[i3];
            listArr[i3] = trackSelection != null ? ImmutableList.z(trackSelection) : ImmutableList.y();
        }
        return b(mappedTrackInfo, listArr);
    }

    public static Tracks b(MappingTrackSelector.MappedTrackInfo mappedTrackInfo, List[] listArr) {
        boolean z2;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        for (int i3 = 0; i3 < mappedTrackInfo.d(); i3++) {
            TrackGroupArray trackGroupArrayF = mappedTrackInfo.f(i3);
            List list = listArr[i3];
            for (int i4 = 0; i4 < trackGroupArrayF.f44987a; i4++) {
                TrackGroup trackGroupB = trackGroupArrayF.b(i4);
                boolean z3 = mappedTrackInfo.a(i3, i4, false) != 0;
                int i5 = trackGroupB.f41153a;
                int[] iArr = new int[i5];
                boolean[] zArr = new boolean[i5];
                for (int i6 = 0; i6 < trackGroupB.f41153a; i6++) {
                    iArr[i6] = mappedTrackInfo.g(i3, i4, i6);
                    int i7 = 0;
                    while (true) {
                        if (i7 >= list.size()) {
                            z2 = false;
                            break;
                        }
                        TrackSelection trackSelection = (TrackSelection) list.get(i7);
                        if (trackSelection.h().equals(trackGroupB) && trackSelection.g(i6) != -1) {
                            z2 = true;
                            break;
                        }
                        i7++;
                    }
                    zArr[i6] = z2;
                }
                builder.a(new Tracks.Group(trackGroupB, z3, iArr, zArr));
            }
        }
        TrackGroupArray trackGroupArrayH = mappedTrackInfo.h();
        for (int i8 = 0; i8 < trackGroupArrayH.f44987a; i8++) {
            TrackGroup trackGroupB2 = trackGroupArrayH.b(i8);
            int[] iArr2 = new int[trackGroupB2.f41153a];
            Arrays.fill(iArr2, 0);
            builder.a(new Tracks.Group(trackGroupB2, false, iArr2, new boolean[trackGroupB2.f41153a]));
        }
        return new Tracks(builder.m());
    }

    public static ExoTrackSelection[] c(ExoTrackSelection.Definition[] definitionArr, AdaptiveTrackSelectionFactory adaptiveTrackSelectionFactory) {
        ExoTrackSelection[] exoTrackSelectionArr = new ExoTrackSelection[definitionArr.length];
        boolean z2 = false;
        for (int i3 = 0; i3 < definitionArr.length; i3++) {
            ExoTrackSelection.Definition definition = definitionArr[i3];
            if (definition != null) {
                int[] iArr = definition.f45436b;
                if (iArr.length <= 1 || z2) {
                    exoTrackSelectionArr[i3] = new FixedTrackSelection(definition.f45435a, iArr[0], definition.f45437c);
                } else {
                    exoTrackSelectionArr[i3] = adaptiveTrackSelectionFactory.a(definition);
                    z2 = true;
                }
            }
        }
        return exoTrackSelectionArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x000f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Point d(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto Lf
            r3 = 0
            r0 = 1
            if (r6 <= r7) goto L8
            r1 = r0
            goto L9
        L8:
            r1 = r3
        L9:
            if (r4 <= r5) goto Lc
            r3 = r0
        Lc:
            if (r1 == r3) goto Lf
            goto L12
        Lf:
            r2 = r5
            r5 = r4
            r4 = r2
        L12:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L22
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = androidx.media3.common.util.Util.m(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L22:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = androidx.media3.common.util.Util.m(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.trackselection.TrackSelectionUtil.d(boolean, int, int, int, int):android.graphics.Point");
    }
}
