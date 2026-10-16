package androidx.media3.transformer;

import android.content.Context;
import android.util.Pair;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.transformer.Composition;
import androidx.media3.transformer.EditedMediaItem;
import androidx.media3.transformer.EditedMediaItemSequence;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.io.File;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class TransmuxTranscodeHelper {

    /* JADX INFO: renamed from: androidx.media3.transformer.TransmuxTranscodeHelper$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ SettableFuture f48587a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f48588b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f48589c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Composition f48590d;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                if (this.f48587a.isCancelled()) {
                    return;
                }
                Mp4Info mp4InfoA = Mp4Info.a(this.f48588b, this.f48589c);
                long j3 = mp4InfoA.f48298b;
                ImmutableList.Builder builder = new ImmutableList.Builder();
                if (j3 != -9223372036854775807L) {
                    for (int i3 = 0; i3 < this.f48590d.f47968a.size(); i3++) {
                        ImmutableList immutableList = ((EditedMediaItemSequence) this.f48590d.f47968a.get(i3)).f48110a;
                        long j4 = j3;
                        int i4 = 0;
                        while (i4 < immutableList.size() && j4 > 0) {
                            long jG = TransmuxTranscodeHelper.g(this.f48588b, ((EditedMediaItem) immutableList.get(i4)).f48095a);
                            if (jG > j4) {
                                break;
                            }
                            j4 -= jG;
                            i4++;
                        }
                        j4 = 0;
                        builder.a(new Pair(Integer.valueOf(i4), Long.valueOf(j4)));
                    }
                }
                this.f48587a.B(new ResumeMetadata(j3, builder.m(), mp4InfoA.f48302f));
            } catch (Exception e3) {
                this.f48587a.C(e3);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static final class ResumeMetadata {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f48594a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImmutableList f48595b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Format f48596c;

        public ResumeMetadata(long j3, ImmutableList immutableList, Format format) {
            this.f48594a = j3;
            this.f48595b = immutableList;
            this.f48596c = format;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Composition b(Composition composition, boolean z2, boolean z3, ResumeMetadata resumeMetadata) {
        long jLongValue;
        int iIntValue;
        int i3;
        Composition.Builder builderA = composition.a();
        ImmutableList immutableList = composition.f47968a;
        ArrayList arrayList = new ArrayList();
        ImmutableList immutableList2 = resumeMetadata != null ? resumeMetadata.f48595b : null;
        int i4 = 0;
        while (i4 < immutableList.size()) {
            EditedMediaItemSequence editedMediaItemSequence = (EditedMediaItemSequence) immutableList.get(i4);
            ImmutableList immutableList3 = editedMediaItemSequence.f48110a;
            ArrayList arrayList2 = new ArrayList();
            if (immutableList2 != null) {
                iIntValue = ((Integer) ((Pair) immutableList2.get(i4)).first).intValue();
                jLongValue = ((Long) ((Pair) immutableList2.get(i4)).second).longValue();
            } else {
                jLongValue = 0;
                iIntValue = 0;
            }
            int i5 = iIntValue;
            while (i5 < immutableList3.size()) {
                EditedMediaItem editedMediaItem = (EditedMediaItem) immutableList3.get(i5);
                EditedMediaItem.Builder builderA2 = editedMediaItem.a();
                if (i5 == iIntValue) {
                    i3 = i4;
                    builderA2.d(editedMediaItem.f48095a.a().b(editedMediaItem.f48095a.f40718f.a().j(editedMediaItem.f48095a.f40718f.f40746a + Util.t1(jLongValue)).f()).a());
                } else {
                    i3 = i4;
                }
                if (z2) {
                    builderA2.e(true);
                }
                if (z3) {
                    builderA2.f(true);
                }
                arrayList2.add(builderA2.a());
                i5++;
                i4 = i3;
            }
            arrayList.add(new EditedMediaItemSequence.Builder(arrayList2).d(editedMediaItemSequence.f48111b).c());
            i4++;
        }
        builderA.b(arrayList);
        return builderA.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Composition c(Composition composition, long j3, long j4, long j5, boolean z2, boolean z3) {
        EditedMediaItem editedMediaItem = (EditedMediaItem) ((EditedMediaItemSequence) composition.f47968a.get(0)).f48110a.get(0);
        return composition.a().b(ImmutableList.z(new EditedMediaItemSequence.Builder(editedMediaItem.a().d(editedMediaItem.f48095a.a().b(new MediaItem.ClippingConfiguration.Builder().k(j3).i(j4).l(z2).f()).a()).b(j5).c(z3 ? new Effects(editedMediaItem.f48101g.f48126a, ImmutableList.y()) : editedMediaItem.f48101g).a()).c())).a();
    }

    public static ListenableFuture d(final File file, final File file2) {
        final SettableFuture settableFutureF = SettableFuture.F();
        new Thread("TransmuxTranscodeHelper:CopyFile") { // from class: androidx.media3.transformer.TransmuxTranscodeHelper.3
            /* JADX WARN: Removed duplicated region for block: B:32:0x0055 A[Catch: IOException -> 0x0058, TRY_LEAVE, TryCatch #1 {IOException -> 0x0058, blocks: (B:30:0x0050, B:32:0x0055), top: B:36:0x0050 }] */
            /* JADX WARN: Removed duplicated region for block: B:36:0x0050 A[EXC_TOP_SPLITTER, SYNTHETIC] */
            @Override // java.lang.Thread, java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() throws java.lang.Throwable {
                /*
                    r5 = this;
                    com.google.common.util.concurrent.SettableFuture r0 = r2
                    boolean r0 = r0.isCancelled()
                    if (r0 == 0) goto L9
                    goto L4d
                L9:
                    r0 = 0
                    java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L3a
                    java.io.File r2 = r3     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L3a
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L35 java.lang.Exception -> L3a
                    java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L30
                    java.io.File r3 = r4     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L30
                    r2.<init>(r3)     // Catch: java.lang.Throwable -> L2b java.lang.Exception -> L30
                    com.google.common.io.ByteStreams.b(r1, r2)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
                    com.google.common.util.concurrent.SettableFuture r3 = r2     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
                    r3.B(r0)     // Catch: java.lang.Throwable -> L27 java.lang.Exception -> L29
                    r1.close()     // Catch: java.io.IOException -> L4d
                    r2.close()     // Catch: java.io.IOException -> L4d
                    return
                L27:
                    r0 = move-exception
                    goto L4e
                L29:
                    r0 = move-exception
                    goto L3e
                L2b:
                    r2 = move-exception
                    r4 = r2
                    r2 = r0
                    r0 = r4
                    goto L4e
                L30:
                    r2 = move-exception
                    r4 = r2
                    r2 = r0
                    r0 = r4
                    goto L3e
                L35:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    r1 = r2
                    goto L4e
                L3a:
                    r1 = move-exception
                    r2 = r0
                    r0 = r1
                    r1 = r2
                L3e:
                    com.google.common.util.concurrent.SettableFuture r3 = r2     // Catch: java.lang.Throwable -> L27
                    r3.C(r0)     // Catch: java.lang.Throwable -> L27
                    if (r1 == 0) goto L48
                    r1.close()     // Catch: java.io.IOException -> L4d
                L48:
                    if (r2 == 0) goto L4d
                    r2.close()     // Catch: java.io.IOException -> L4d
                L4d:
                    return
                L4e:
                    if (r1 == 0) goto L53
                    r1.close()     // Catch: java.io.IOException -> L58
                L53:
                    if (r2 == 0) goto L58
                    r2.close()     // Catch: java.io.IOException -> L58
                L58:
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.media3.transformer.TransmuxTranscodeHelper.AnonymousClass3.run():void");
            }
        }.start();
        return settableFutureF;
    }

    public static Composition e(Composition composition, String str) {
        Composition compositionB = b((Composition) Assertions.e(composition), false, true, null);
        Composition.Builder builderA = compositionB.a();
        ArrayList arrayList = new ArrayList(compositionB.f47968a);
        arrayList.add(new EditedMediaItemSequence.Builder(new EditedMediaItem.Builder(new MediaItem.Builder().l(str).a()).a()).c());
        builderA.b(arrayList);
        builderA.c(true);
        return builderA.a();
    }

    public static Composition f(String str, long j3) {
        return new Composition.Builder(new EditedMediaItemSequence.Builder(new EditedMediaItem.Builder(new MediaItem.Builder().l(str).b(new MediaItem.ClippingConfiguration.Builder().h(Util.t1(j3)).f()).a()).e(true).a()).c(), new EditedMediaItemSequence[0]).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long g(Context context, MediaItem mediaItem) {
        String string = ((MediaItem.LocalConfiguration) Assertions.e(mediaItem.f40714b)).f40810a.toString();
        long jP0 = Util.P0(mediaItem.f40718f.f40746a);
        long j3 = mediaItem.f40718f.f40748c;
        return (j3 != Long.MIN_VALUE ? Util.P0(j3) : Mp4Info.a(context, string).f48297a) - jP0;
    }

    public static ListenableFuture h(final Context context, final String str, final long j3) {
        final SettableFuture settableFutureF = SettableFuture.F();
        new Thread("TransmuxTranscodeHelper:Mp4Info") { // from class: androidx.media3.transformer.TransmuxTranscodeHelper.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    settableFutureF.B(Mp4Info.b(context, str, j3));
                } catch (Exception e3) {
                    settableFutureF.C(e3);
                }
            }
        }.start();
        return settableFutureF;
    }
}
