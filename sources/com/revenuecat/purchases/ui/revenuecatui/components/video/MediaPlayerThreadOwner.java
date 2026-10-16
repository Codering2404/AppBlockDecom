package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner;
import com.revenuecat.purchases.ui.revenuecatui.helpers.Logger;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class MediaPlayerThreadOwner {

    @Deprecated
    public static final long DETACH_SURFACE_AWAIT_TIMEOUT_MS = 1000;

    @Deprecated
    public static final long POSITION_POLL_INTERVAL_MS = 250;
    private final Context appContext;
    private Surface currentSurface;
    private boolean looping;
    private final Handler mainHandler;
    private final boolean muteAudio;
    private volatile PendingPlaybackState pendingPlaybackState;
    private final AtomicLong playbackCommandId;
    private volatile PlaybackSnapshot playbackSnapshot;
    private MediaPlayer player;
    private final Function0<MediaPlayer> playerFactory;
    private final MediaPlayerThreadOwner$positionTicker$1 positionTicker;
    private boolean positionTickerScheduled;
    private volatile boolean released;
    private final Handler workerHandler;
    private final HandlerThread workerThread;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class PendingPlaybackState {
        private final long commandId;
        private final boolean isPlaying;

        public PendingPlaybackState(boolean z2, long j3) {
            this.isPlaying = z2;
            this.commandId = j3;
        }

        public static /* synthetic */ PendingPlaybackState copy$default(PendingPlaybackState pendingPlaybackState, boolean z2, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z2 = pendingPlaybackState.isPlaying;
            }
            if ((i3 & 2) != 0) {
                j3 = pendingPlaybackState.commandId;
            }
            return pendingPlaybackState.copy(z2, j3);
        }

        public final boolean component1() {
            return this.isPlaying;
        }

        public final long component2() {
            return this.commandId;
        }

        public final PendingPlaybackState copy(boolean z2, long j3) {
            return new PendingPlaybackState(z2, j3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PendingPlaybackState)) {
                return false;
            }
            PendingPlaybackState pendingPlaybackState = (PendingPlaybackState) obj;
            return this.isPlaying == pendingPlaybackState.isPlaying && this.commandId == pendingPlaybackState.commandId;
        }

        public final long getCommandId() {
            return this.commandId;
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isPlaying) * 31) + Long.hashCode(this.commandId);
        }

        public final boolean isPlaying() {
            return this.isPlaying;
        }

        public String toString() {
            return "PendingPlaybackState(isPlaying=" + this.isPlaying + ", commandId=" + this.commandId + ')';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class PlaybackSnapshot {
        private final int audioSessionId;
        private final int currentPositionMs;
        private final int durationMs;
        private final boolean isPlaying;
        private final boolean prepared;

        public PlaybackSnapshot() {
            this(false, 0, 0, false, 0, 31, null);
        }

        public static /* synthetic */ PlaybackSnapshot copy$default(PlaybackSnapshot playbackSnapshot, boolean z2, int i3, int i4, boolean z3, int i5, int i6, Object obj) {
            if ((i6 & 1) != 0) {
                z2 = playbackSnapshot.prepared;
            }
            if ((i6 & 2) != 0) {
                i3 = playbackSnapshot.durationMs;
            }
            if ((i6 & 4) != 0) {
                i4 = playbackSnapshot.currentPositionMs;
            }
            if ((i6 & 8) != 0) {
                z3 = playbackSnapshot.isPlaying;
            }
            if ((i6 & 16) != 0) {
                i5 = playbackSnapshot.audioSessionId;
            }
            int i7 = i5;
            int i8 = i4;
            return playbackSnapshot.copy(z2, i3, i8, z3, i7);
        }

        public final boolean component1() {
            return this.prepared;
        }

        public final int component2() {
            return this.durationMs;
        }

        public final int component3() {
            return this.currentPositionMs;
        }

        public final boolean component4() {
            return this.isPlaying;
        }

        public final int component5() {
            return this.audioSessionId;
        }

        public final PlaybackSnapshot copy(boolean z2, int i3, int i4, boolean z3, int i5) {
            return new PlaybackSnapshot(z2, i3, i4, z3, i5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PlaybackSnapshot)) {
                return false;
            }
            PlaybackSnapshot playbackSnapshot = (PlaybackSnapshot) obj;
            return this.prepared == playbackSnapshot.prepared && this.durationMs == playbackSnapshot.durationMs && this.currentPositionMs == playbackSnapshot.currentPositionMs && this.isPlaying == playbackSnapshot.isPlaying && this.audioSessionId == playbackSnapshot.audioSessionId;
        }

        public final int getAudioSessionId() {
            return this.audioSessionId;
        }

        public final int getCurrentPositionMs() {
            return this.currentPositionMs;
        }

        public final int getDurationMs() {
            return this.durationMs;
        }

        public final boolean getPrepared() {
            return this.prepared;
        }

        public int hashCode() {
            return (((((((Boolean.hashCode(this.prepared) * 31) + Integer.hashCode(this.durationMs)) * 31) + Integer.hashCode(this.currentPositionMs)) * 31) + Boolean.hashCode(this.isPlaying)) * 31) + Integer.hashCode(this.audioSessionId);
        }

        public final boolean isPlaying() {
            return this.isPlaying;
        }

        public String toString() {
            return "PlaybackSnapshot(prepared=" + this.prepared + ", durationMs=" + this.durationMs + ", currentPositionMs=" + this.currentPositionMs + ", isPlaying=" + this.isPlaying + ", audioSessionId=" + this.audioSessionId + ')';
        }

        public PlaybackSnapshot(boolean z2, int i3, int i4, boolean z3, int i5) {
            this.prepared = z2;
            this.durationMs = i3;
            this.currentPositionMs = i4;
            this.isPlaying = z3;
            this.audioSessionId = i5;
        }

        public /* synthetic */ PlaybackSnapshot(boolean z2, int i3, int i4, boolean z3, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? false : z2, (i6 & 2) != 0 ? 0 : i3, (i6 & 4) != 0 ? 0 : i4, (i6 & 8) != 0 ? false : z3, (i6 & 16) != 0 ? 0 : i5);
        }
    }

    /* JADX INFO: renamed from: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$prepare$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class C25301 extends Lambda implements Function0<Unit> {
        final /* synthetic */ Function2<Integer, Integer, Unit> $onPrepared;
        final /* synthetic */ Function2<Integer, Integer, Unit> $onVideoSizeChanged;
        final /* synthetic */ Uri $uri;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C25301(Uri uri, Function2<? super Integer, ? super Integer, Unit> function2, Function2<? super Integer, ? super Integer, Unit> function22) {
            super(0);
            this.$uri = uri;
            this.$onPrepared = function2;
            this.$onVideoSizeChanged = function22;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$14$lambda$10(final MediaPlayerThreadOwner mediaPlayerThreadOwner, final Function2 function2, MediaPlayer mediaPlayer, final int i3, final int i4) {
            if (mediaPlayerThreadOwner.released) {
                return;
            }
            mediaPlayerThreadOwner.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.e
                @Override // java.lang.Runnable
                public final void run() {
                    MediaPlayerThreadOwner.C25301.invoke$lambda$14$lambda$10$lambda$9(mediaPlayerThreadOwner, function2, i3, i4);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$14$lambda$10$lambda$9(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function2 function2, int i3, int i4) {
            if (mediaPlayerThreadOwner.released) {
                return;
            }
            function2.invoke(Integer.valueOf(i3), Integer.valueOf(i4));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$14$lambda$13(MediaPlayerThreadOwner mediaPlayerThreadOwner, MediaPlayer mediaPlayer) {
            if (mediaPlayer == null) {
                return;
            }
            PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner.playbackSnapshot;
            int durationMs = playbackSnapshot.getDurationMs();
            try {
                durationMs = mediaPlayer.getCurrentPosition();
            } catch (Exception unused) {
            }
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, durationMs, false, 0, 19, null);
            MediaPlayerThreadOwner.clearPendingPlaybackState$default(mediaPlayerThreadOwner, null, 1, null);
            mediaPlayerThreadOwner.stopPositionTicker();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$14$lambda$8(final MediaPlayerThreadOwner mediaPlayerThreadOwner, final Function2 function2, MediaPlayer mediaPlayer) {
            final int videoWidth;
            final int videoHeight;
            int duration;
            if (mediaPlayerThreadOwner.released || mediaPlayer == null) {
                return;
            }
            int currentPosition = 0;
            try {
                videoWidth = mediaPlayer.getVideoWidth();
            } catch (Exception unused) {
                videoWidth = 0;
            }
            try {
                videoHeight = mediaPlayer.getVideoHeight();
            } catch (Exception unused2) {
                videoHeight = 0;
            }
            PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner.playbackSnapshot;
            try {
                duration = mediaPlayer.getDuration();
            } catch (Exception unused3) {
                duration = 0;
            }
            try {
                currentPosition = mediaPlayer.getCurrentPosition();
            } catch (Exception unused4) {
            }
            int i3 = currentPosition;
            int audioSessionId = playbackSnapshot.getAudioSessionId();
            try {
                audioSessionId = mediaPlayer.getAudioSessionId();
            } catch (Exception unused5) {
            }
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, true, duration, i3, false, audioSessionId, 8, null);
            mediaPlayerThreadOwner.mainHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.d
                @Override // java.lang.Runnable
                public final void run() {
                    MediaPlayerThreadOwner.C25301.invoke$lambda$14$lambda$8$lambda$7(mediaPlayerThreadOwner, function2, videoWidth, videoHeight);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$14$lambda$8$lambda$7(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function2 function2, int i3, int i4) {
            if (mediaPlayerThreadOwner.released) {
                return;
            }
            function2.invoke(Integer.valueOf(i3), Integer.valueOf(i4));
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            m862invoke();
            return Unit.f139807a;
        }

        /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
        public final void m862invoke() {
            MediaPlayerThreadOwner.clearPendingPlaybackState$default(MediaPlayerThreadOwner.this, null, 1, null);
            MediaPlayer mediaPlayerEnsurePlayer = MediaPlayerThreadOwner.this.ensurePlayer();
            MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner.playbackSnapshot, false, 0, 0, false, 0, 16, null);
            MediaPlayerThreadOwner.this.stopPositionTicker();
            final MediaPlayerThreadOwner mediaPlayerThreadOwner2 = MediaPlayerThreadOwner.this;
            Uri uri = this.$uri;
            final Function2<Integer, Integer, Unit> function2 = this.$onPrepared;
            final Function2<Integer, Integer, Unit> function22 = this.$onVideoSizeChanged;
            try {
                mediaPlayerEnsurePlayer.reset();
                Surface surface = mediaPlayerThreadOwner2.currentSurface;
                if (surface != null) {
                    mediaPlayerEnsurePlayer.setSurface(surface);
                } else {
                    Logger.INSTANCE.w("TextureVideoView: Preparing media player without a surface.Audio may play before video is attached.");
                }
                mediaPlayerEnsurePlayer.setLooping(mediaPlayerThreadOwner2.looping);
                if (mediaPlayerThreadOwner2.muteAudio) {
                    mediaPlayerEnsurePlayer.setVolume(0.0f, 0.0f);
                }
                mediaPlayerEnsurePlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.f
                    @Override // android.media.MediaPlayer.OnPreparedListener
                    public final void onPrepared(MediaPlayer mediaPlayer) {
                        MediaPlayerThreadOwner.C25301.invoke$lambda$14$lambda$8(mediaPlayerThreadOwner2, function2, mediaPlayer);
                    }
                });
                mediaPlayerEnsurePlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.g
                    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
                    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i3, int i4) {
                        MediaPlayerThreadOwner.C25301.invoke$lambda$14$lambda$10(mediaPlayerThreadOwner2, function22, mediaPlayer, i3, i4);
                    }
                });
                mediaPlayerEnsurePlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.h
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        MediaPlayerThreadOwner.C25301.invoke$lambda$14$lambda$13(mediaPlayerThreadOwner2, mediaPlayer);
                    }
                });
                mediaPlayerEnsurePlayer.setDataSource(mediaPlayerThreadOwner2.appContext, uri);
                mediaPlayerEnsurePlayer.prepareAsync();
            } catch (Exception e3) {
                String str = "Could not prepare media player: " + e3.getMessage();
                if (str != null) {
                    Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v6, types: [com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$positionTicker$1] */
    public MediaPlayerThreadOwner(Context context, boolean z2, Function0<? extends MediaPlayer> playerFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(playerFactory, "playerFactory");
        this.muteAudio = z2;
        this.playerFactory = playerFactory;
        this.appContext = context.getApplicationContext();
        this.mainHandler = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("RC-TextureVideoViewPlayer");
        handlerThread.start();
        this.workerThread = handlerThread;
        this.workerHandler = new Handler(handlerThread.getLooper());
        this.playbackSnapshot = new PlaybackSnapshot(false, 0, 0, false, 0, 31, null);
        this.playbackCommandId = new AtomicLong(0L);
        this.positionTicker = new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner$positionTicker$1
            @Override // java.lang.Runnable
            public void run() {
                boolean zIsPlaying;
                if (this.this$0.released) {
                    this.this$0.positionTickerScheduled = false;
                    return;
                }
                MediaPlayer mediaPlayer = this.this$0.player;
                if (mediaPlayer == null || !this.this$0.playbackSnapshot.getPrepared()) {
                    this.this$0.positionTickerScheduled = false;
                    return;
                }
                try {
                    zIsPlaying = mediaPlayer.isPlaying();
                } catch (Exception unused) {
                    zIsPlaying = false;
                }
                MediaPlayerThreadOwner mediaPlayerThreadOwner = this.this$0;
                MediaPlayerThreadOwner.PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner.playbackSnapshot;
                int currentPositionMs = playbackSnapshot.getCurrentPositionMs();
                try {
                    currentPositionMs = mediaPlayer.getCurrentPosition();
                } catch (Exception unused2) {
                }
                mediaPlayerThreadOwner.playbackSnapshot = MediaPlayerThreadOwner.PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, currentPositionMs, zIsPlaying, 0, 19, null);
                if (zIsPlaying) {
                    this.this$0.workerHandler.postDelayed(this, 250L);
                } else {
                    this.this$0.positionTickerScheduled = false;
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearPendingPlaybackState(Long l3) {
        PendingPlaybackState pendingPlaybackState = this.pendingPlaybackState;
        if (pendingPlaybackState == null) {
            return;
        }
        if (l3 == null || pendingPlaybackState.getCommandId() == l3.longValue()) {
            this.pendingPlaybackState = null;
        }
    }

    static /* synthetic */ void clearPendingPlaybackState$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Long l3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l3 = null;
        }
        mediaPlayerThreadOwner.clearPendingPlaybackState(l3);
    }

    public static /* synthetic */ void clearSurfaceBlocking$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            surface = null;
        }
        mediaPlayerThreadOwner.clearSurfaceBlocking(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearSurfaceBlocking$lambda$1(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface, CountDownLatch countDownLatch) {
        try {
            mediaPlayerThreadOwner.detachAndReleaseSurface(surface);
        } finally {
            countDownLatch.countDown();
        }
    }

    private final void detachAndReleaseSurface(Surface surface) {
        setSurfaceInternal(null);
        releaseSurface(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MediaPlayer ensurePlayer() {
        int audioSessionId;
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer != null) {
            return mediaPlayer;
        }
        MediaPlayer mediaPlayer2 = (MediaPlayer) this.playerFactory.invoke();
        this.player = mediaPlayer2;
        PlaybackSnapshot playbackSnapshot = this.playbackSnapshot;
        try {
            audioSessionId = mediaPlayer2.getAudioSessionId();
        } catch (Exception unused) {
            audioSessionId = 0;
        }
        this.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, 0, false, audioSessionId, 15, null);
        Surface surface = this.currentSurface;
        if (surface != null) {
            try {
                mediaPlayer2.setSurface(surface);
            } catch (Exception e3) {
                String str = "Could not attach media surface: " + e3.getMessage();
                if (str != null) {
                    Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                }
            }
        }
        return mediaPlayer2;
    }

    private final <T> T getPlayerValue(MediaPlayer mediaPlayer, T t2, Function1<? super MediaPlayer, ? extends T> function1) {
        try {
            return (T) function1.invoke(mediaPlayer);
        } catch (Exception unused) {
            return t2;
        }
    }

    private final long markPendingPlaybackState(boolean z2) {
        long jIncrementAndGet = this.playbackCommandId.incrementAndGet();
        this.pendingPlaybackState = new PendingPlaybackState(z2, jIncrementAndGet);
        return jIncrementAndGet;
    }

    private final void post(final Function0<Unit> function0) {
        if (this.released) {
            return;
        }
        this.workerHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.a
            @Override // java.lang.Runnable
            public final void run() {
                MediaPlayerThreadOwner.post$lambda$17(this.f92324a, function0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void post$lambda$17(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function0 function0) {
        if (mediaPlayerThreadOwner.released) {
            return;
        }
        function0.invoke();
    }

    public static /* synthetic */ void release$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            surface = null;
        }
        mediaPlayerThreadOwner.release(surface);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void release$lambda$6(MediaPlayerThreadOwner mediaPlayerThreadOwner, Surface surface) {
        try {
            mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner.playbackSnapshot, false, 0, 0, false, 0, 22, null);
            MediaPlayer mediaPlayer = mediaPlayerThreadOwner.player;
            mediaPlayerThreadOwner.player = null;
            mediaPlayerThreadOwner.currentSurface = null;
            mediaPlayerThreadOwner.stopPositionTicker();
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.setSurface(null);
                } catch (Exception unused) {
                }
            }
            mediaPlayerThreadOwner.releaseSurface(surface);
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.release();
                } catch (Exception e3) {
                    String str = "Could not release media player: " + e3.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                    }
                }
            }
            mediaPlayerThreadOwner.workerThread.quitSafely();
        } catch (Throwable th) {
            mediaPlayerThreadOwner.workerThread.quitSafely();
            throw th;
        }
    }

    private final void releaseSurface(Surface surface) {
        if (surface != null) {
            try {
                surface.release();
            } catch (Exception e3) {
                String str = "Could not release media surface: " + e3.getMessage();
                if (str != null) {
                    Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                }
            }
        }
    }

    private final void safely(Function0<Unit> function0, Function1<? super Exception, String> function1) {
        try {
            function0.invoke();
        } catch (Exception e3) {
            String str = (String) function1.invoke(e3);
            if (str != null) {
                Logger.INSTANCE.e("TextureVideoView: " + str, e3);
            }
        }
    }

    static /* synthetic */ void safely$default(MediaPlayerThreadOwner mediaPlayerThreadOwner, Function0 function0, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = new Function1() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.safely.1
                @Override // kotlin.jvm.functions.Function1
                public final Void invoke(Exception it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return null;
                }
            };
        }
        try {
            function0.invoke();
        } catch (Exception e3) {
            String str = (String) function1.invoke(e3);
            if (str != null) {
                Logger.INSTANCE.e("TextureVideoView: " + str, e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setSurfaceInternal(Surface surface) {
        this.currentSurface = surface;
        MediaPlayer mediaPlayer = this.player;
        if (mediaPlayer == null) {
            return;
        }
        try {
            mediaPlayer.setSurface(surface);
        } catch (Exception e3) {
            String str = "Could not set media surface: " + e3.getMessage();
            if (str != null) {
                Logger.INSTANCE.e("TextureVideoView: " + str, e3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startPositionTicker() {
        if (this.positionTickerScheduled) {
            return;
        }
        this.positionTickerScheduled = true;
        this.workerHandler.post(this.positionTicker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopPositionTicker() {
        this.positionTickerScheduled = false;
        this.workerHandler.removeCallbacks(this.positionTicker);
    }

    private final void updatePlaybackSnapshot(Function1<? super PlaybackSnapshot, PlaybackSnapshot> function1) {
        this.playbackSnapshot = (PlaybackSnapshot) function1.invoke(this.playbackSnapshot);
    }

    public final void clearSurfaceBlocking(final Surface surface) {
        if (Intrinsics.areEqual(Looper.myLooper(), this.workerThread.getLooper())) {
            detachAndReleaseSurface(surface);
            return;
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        if (!this.workerHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.c
            @Override // java.lang.Runnable
            public final void run() {
                MediaPlayerThreadOwner.clearSurfaceBlocking$lambda$1(this.f92328a, surface, countDownLatch);
            }
        })) {
            releaseSurface(surface);
            Logger.INSTANCE.w("TextureVideoView: Could not post surface detach to worker thread. Released provided surface locally.");
            return;
        }
        try {
            if (countDownLatch.await(1000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            Logger.INSTANCE.w("TextureVideoView: Timed out waiting for surface detach on worker thread. Surface release will complete asynchronously on the worker thread.");
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            Logger.INSTANCE.w("TextureVideoView: Interrupted while waiting for surface detach. Surface release will complete asynchronously on the worker thread.");
        }
    }

    public final int getAudioSessionId() {
        return this.playbackSnapshot.getAudioSessionId();
    }

    public final int getCurrentPosition() {
        return this.playbackSnapshot.getCurrentPositionMs();
    }

    public final int getDuration() {
        return this.playbackSnapshot.getDurationMs();
    }

    public final boolean isPlaying() {
        PendingPlaybackState pendingPlaybackState = this.pendingPlaybackState;
        return pendingPlaybackState != null ? pendingPlaybackState.isPlaying() : this.playbackSnapshot.isPlaying();
    }

    public final void pause() {
        if (this.released || !this.playbackSnapshot.getPrepared()) {
            return;
        }
        final long jMarkPendingPlaybackState = markPendingPlaybackState(false);
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.pause.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m861invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m861invoke() {
                if (!MediaPlayerThreadOwner.this.playbackSnapshot.getPrepared()) {
                    MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                MediaPlayer mediaPlayer = MediaPlayerThreadOwner.this.player;
                if (mediaPlayer == null) {
                    MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
                try {
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                    }
                    PlaybackSnapshot playbackSnapshot = mediaPlayerThreadOwner.playbackSnapshot;
                    int currentPositionMs = playbackSnapshot.getCurrentPositionMs();
                    try {
                        currentPositionMs = mediaPlayer.getCurrentPosition();
                    } catch (Exception unused) {
                    }
                    mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(playbackSnapshot, false, 0, currentPositionMs, false, 0, 19, null);
                    mediaPlayerThreadOwner.stopPositionTicker();
                } catch (Exception e3) {
                    String str = "Could not pause media player: " + e3.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                    }
                }
                MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
            }
        });
    }

    public final void prepare(Uri uri, Function2<? super Integer, ? super Integer, Unit> onPrepared, Function2<? super Integer, ? super Integer, Unit> onVideoSizeChanged) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(onPrepared, "onPrepared");
        Intrinsics.checkNotNullParameter(onVideoSizeChanged, "onVideoSizeChanged");
        post(new C25301(uri, onPrepared, onVideoSizeChanged));
    }

    public final void release(final Surface surface) {
        if (this.released) {
            releaseSurface(surface);
            return;
        }
        this.released = true;
        clearPendingPlaybackState$default(this, null, 1, null);
        this.workerHandler.post(new Runnable() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.b
            @Override // java.lang.Runnable
            public final void run() {
                MediaPlayerThreadOwner.release$lambda$6(this.f92326a, surface);
            }
        });
    }

    public final void seekTo(final int i3) {
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.seekTo.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m863invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m863invoke() {
                MediaPlayer mediaPlayer;
                if (!MediaPlayerThreadOwner.this.playbackSnapshot.getPrepared() || i3 < 0 || (mediaPlayer = MediaPlayerThreadOwner.this.player) == null) {
                    return;
                }
                MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
                int i4 = i3;
                try {
                    mediaPlayer.seekTo(i4);
                    mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner.playbackSnapshot, false, 0, i4, false, 0, 27, null);
                } catch (Exception e3) {
                    String str = "Could not seek media player: " + e3.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                    }
                }
            }
        });
    }

    public final void setLooping(final boolean z2) {
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.setLooping.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m864invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m864invoke() {
                Unit unit;
                MediaPlayerThreadOwner.this.looping = z2;
                MediaPlayer mediaPlayer = MediaPlayerThreadOwner.this.player;
                if (mediaPlayer != null) {
                    try {
                        mediaPlayer.setLooping(z2);
                    } catch (Exception e3) {
                        String str = "Could not set looping mode: " + e3.getMessage();
                        if (str != null) {
                            Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                        }
                    }
                    unit = Unit.f139807a;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    Logger.INSTANCE.w("TextureVideoView: Looping was set before media player initialization. Value cached for prepare.");
                }
            }
        });
    }

    public final void setSurface(final Surface surface) {
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.setSurface.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m865invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m865invoke() {
                MediaPlayerThreadOwner.this.setSurfaceInternal(surface);
            }
        });
    }

    public final void start() {
        if (this.released || !this.playbackSnapshot.getPrepared()) {
            return;
        }
        final long jMarkPendingPlaybackState = markPendingPlaybackState(true);
        post(new Function0<Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.start.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m866invoke();
                return Unit.f139807a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m866invoke() {
                if (!MediaPlayerThreadOwner.this.playbackSnapshot.getPrepared()) {
                    MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                MediaPlayer mediaPlayer = MediaPlayerThreadOwner.this.player;
                if (mediaPlayer == null) {
                    MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
                    return;
                }
                MediaPlayerThreadOwner mediaPlayerThreadOwner = MediaPlayerThreadOwner.this;
                try {
                    mediaPlayer.start();
                    mediaPlayerThreadOwner.playbackSnapshot = PlaybackSnapshot.copy$default(mediaPlayerThreadOwner.playbackSnapshot, false, 0, 0, true, 0, 23, null);
                    mediaPlayerThreadOwner.startPositionTicker();
                } catch (Exception e3) {
                    String str = "Could not start media player: " + e3.getMessage();
                    if (str != null) {
                        Logger.INSTANCE.e("TextureVideoView: " + str, e3);
                    }
                }
                MediaPlayerThreadOwner.this.clearPendingPlaybackState(Long.valueOf(jMarkPendingPlaybackState));
            }
        });
    }

    public /* synthetic */ MediaPlayerThreadOwner(Context context, boolean z2, Function0 function0, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z2, (i3 & 4) != 0 ? new Function0<MediaPlayer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.MediaPlayerThreadOwner.1
            @Override // kotlin.jvm.functions.Function0
            public final MediaPlayer invoke() {
                return new MediaPlayer();
            }
        } : function0);
    }
}
