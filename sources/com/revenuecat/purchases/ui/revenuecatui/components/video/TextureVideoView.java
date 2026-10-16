package com.revenuecat.purchases.ui.revenuecatui.components.video;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.MediaController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
final class TextureVideoView extends FrameLayout implements MediaController.MediaPlayerControl {
    private Surface attachedSurface;
    private boolean autoStart;
    private MediaController controller;
    private boolean firstFrameRendered;
    private final ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private final boolean muteAudio;
    private Function0<Unit> onReadyCallback;
    private final MediaPlayerThreadOwner playerOwner;
    private int prepareRequestId;
    private boolean prepared;
    private boolean released;
    private boolean resumePlayWhenReady;
    private int resumePosMs;
    private ScaleType scaleType;
    private final boolean showControls;
    private final TextureView texture;
    private Uri uri;
    private int videoHeight;
    private int videoWidth;
    private boolean viewTreeObserverListening;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class PlaybackState {
        public static final int $stable = 0;
        private final boolean playWhenReady;
        private final int positionMs;

        public PlaybackState(int i3, boolean z2) {
            this.positionMs = i3;
            this.playWhenReady = z2;
        }

        public final boolean getPlayWhenReady() {
            return this.playWhenReady;
        }

        public final int getPositionMs() {
            return this.positionMs;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum ScaleType {
        FIT,
        FILL
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextureVideoView(Context context, boolean z2, boolean z3) {
        this(context, null, z2, z3, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(TextureVideoView textureVideoView, View view) {
        MediaController mediaController;
        if (!textureVideoView.showControls || (mediaController = textureVideoView.controller) == null) {
            return;
        }
        mediaController.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applySizing() {
        if (this.released || getWidth() == 0 || getHeight() == 0 || this.videoWidth == 0 || this.videoHeight == 0) {
            return;
        }
        int width = getWidth();
        int height = getHeight();
        float f3 = width;
        float f4 = height;
        float f5 = f3 / f4;
        float f6 = this.videoWidth / this.videoHeight;
        ViewGroup.LayoutParams layoutParams = this.texture.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        if (this.scaleType == ScaleType.FIT) {
            if (f6 > f5) {
                layoutParams2.width = width;
                layoutParams2.height = (int) (f3 / f6);
            } else {
                layoutParams2.height = height;
                layoutParams2.width = (int) (f4 * f6);
            }
        } else if (f6 > f5) {
            layoutParams2.height = height;
            layoutParams2.width = (int) (f4 * f6);
        } else {
            layoutParams2.width = width;
            layoutParams2.height = (int) (f3 / f6);
        }
        layoutParams2.gravity = 17;
        this.texture.setLayoutParams(layoutParams2);
        this.texture.setVisibility(0);
        this.texture.setAlpha(1.0f);
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareIfNeeded() {
        Uri uri;
        if (this.released || (uri = this.uri) == null) {
            return;
        }
        final int i3 = this.prepareRequestId + 1;
        this.prepareRequestId = i3;
        this.prepared = false;
        this.playerOwner.prepare(uri, new Function2<Integer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView.prepareIfNeeded.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(int i4, int i5) {
                MediaController mediaController;
                if (TextureVideoView.this.released || i3 != TextureVideoView.this.prepareRequestId) {
                    return;
                }
                TextureVideoView.this.prepared = true;
                TextureVideoView.this.videoWidth = i4;
                TextureVideoView.this.videoHeight = i5;
                TextureVideoView.this.applySizing();
                if (TextureVideoView.this.resumePosMs > 0) {
                    TextureVideoView textureVideoView = TextureVideoView.this;
                    textureVideoView.safeSeekTo(textureVideoView.resumePosMs);
                } else if (TextureVideoView.this.resumePosMs == 0) {
                    TextureVideoView.this.safeSeekTo(1);
                }
                if (TextureVideoView.this.autoStart || TextureVideoView.this.resumePlayWhenReady) {
                    TextureVideoView.this.start();
                }
                if (!TextureVideoView.this.showControls || (mediaController = TextureVideoView.this.controller) == null) {
                    return;
                }
                mediaController.show();
            }
        }, new Function2<Integer, Integer, Unit>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView.prepareIfNeeded.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke(((Number) obj).intValue(), ((Number) obj2).intValue());
                return Unit.f139807a;
            }

            public final void invoke(int i4, int i5) {
                if (TextureVideoView.this.released || i3 != TextureVideoView.this.prepareRequestId) {
                    return;
                }
                TextureVideoView.this.videoWidth = i4;
                TextureVideoView.this.videoHeight = i5;
                TextureVideoView.this.applySizing();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void safeSeekTo(int i3) {
        if (!this.prepared || i3 <= 0) {
            return;
        }
        this.playerOwner.seekTo(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Surface takeAttachedSurface() {
        Surface surface = this.attachedSurface;
        this.attachedSurface = null;
        return surface;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        return this.playerOwner.getAudioSessionId();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return 0;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        return (!this.prepared || this.released) ? this.resumePosMs : this.playerOwner.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (!this.prepared || this.released) {
            return 0;
        }
        return this.playerOwner.getDuration();
    }

    public final PlaybackState getPlaybackState() {
        return new PlaybackState(this.prepared ? this.playerOwner.getCurrentPosition() : this.resumePosMs, this.prepared ? this.playerOwner.isPlaying() : this.resumePlayWhenReady);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.prepared && !this.released && this.playerOwner.isPlaying();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        release();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        if (!this.prepared || this.released) {
            return;
        }
        this.playerOwner.pause();
    }

    public final void release() {
        if (this.released) {
            return;
        }
        this.released = true;
        this.prepared = false;
        this.prepareRequestId++;
        MediaController mediaController = this.controller;
        if (mediaController != null) {
            mediaController.hide();
        }
        this.controller = null;
        this.playerOwner.release(takeAttachedSurface());
        if (this.viewTreeObserverListening) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.layoutListener);
            this.viewTreeObserverListening = false;
        }
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i3) {
        this.resumePosMs = i3;
        safeSeekTo(i3);
    }

    public final void setAutoStart(boolean z2) {
        this.autoStart = z2;
    }

    public final void setLooping(boolean z2) {
        if (this.released) {
            return;
        }
        this.playerOwner.setLooping(z2);
    }

    public final void setOnReadyCallback(Function0<Unit> function0) {
        this.onReadyCallback = function0;
        if (!this.firstFrameRendered || function0 == null) {
            return;
        }
        function0.invoke();
    }

    public final void setPlaybackState(PlaybackState state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.resumePosMs = state.getPositionMs();
        this.resumePlayWhenReady = state.getPlayWhenReady();
        if (this.prepared) {
            safeSeekTo(this.resumePosMs);
            if (this.resumePlayWhenReady) {
                start();
            } else {
                pause();
            }
        }
    }

    public final void setScaleType(ScaleType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        this.scaleType = type;
        applySizing();
    }

    public final void setVideoURI(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.uri = uri;
        this.prepared = false;
        this.firstFrameRendered = false;
        if (this.resumePosMs == 0) {
            this.resumePlayWhenReady = this.autoStart;
        }
        if (!this.texture.isAvailable() || this.released) {
            return;
        }
        prepareIfNeeded();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        if (!this.prepared || this.released) {
            return;
        }
        this.playerOwner.start();
    }

    public final void startIfNeeded() {
        if (!this.prepared || this.released || this.playerOwner.isPlaying() || !this.autoStart) {
            return;
        }
        start();
    }

    public /* synthetic */ TextureVideoView(Context context, AttributeSet attributeSet, boolean z2, boolean z3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, z2, z3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextureVideoView(Context context, AttributeSet attributeSet, boolean z2, boolean z3) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showControls = z2;
        this.muteAudio = z3;
        TextureView textureView = new TextureView(context);
        this.texture = textureView;
        this.playerOwner = new MediaPlayerThreadOwner(context, z3, null, 4, null);
        this.autoStart = true;
        this.scaleType = ScaleType.FIT;
        this.layoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.i
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                this.f92344a.applySizing();
            }
        };
        setClipToPadding(true);
        setClipChildren(true);
        addView(textureView, new FrameLayout.LayoutParams(-1, -1, 17));
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.TextureVideoView.1
            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureAvailable(SurfaceTexture st, int i3, int i4) {
                Intrinsics.checkNotNullParameter(st, "st");
                if (TextureVideoView.this.released) {
                    return;
                }
                Surface surfaceTakeAttachedSurface = TextureVideoView.this.takeAttachedSurface();
                if (surfaceTakeAttachedSurface != null) {
                    TextureVideoView.this.playerOwner.clearSurfaceBlocking(surfaceTakeAttachedSurface);
                }
                TextureVideoView.this.attachedSurface = new Surface(st);
                TextureVideoView.this.playerOwner.setSurface(TextureVideoView.this.attachedSurface);
                if (!TextureVideoView.this.viewTreeObserverListening) {
                    TextureVideoView.this.getViewTreeObserver().addOnGlobalLayoutListener(TextureVideoView.this.layoutListener);
                    TextureVideoView.this.viewTreeObserverListening = true;
                }
                if (!TextureVideoView.this.prepared) {
                    TextureVideoView.this.prepareIfNeeded();
                    return;
                }
                TextureVideoView textureVideoView = TextureVideoView.this;
                textureVideoView.safeSeekTo(textureVideoView.resumePosMs);
                if (TextureVideoView.this.resumePlayWhenReady) {
                    TextureVideoView.this.start();
                }
                TextureVideoView.this.applySizing();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public boolean onSurfaceTextureDestroyed(SurfaceTexture st) {
                Intrinsics.checkNotNullParameter(st, "st");
                Surface surfaceTakeAttachedSurface = TextureVideoView.this.takeAttachedSurface();
                if (TextureVideoView.this.released) {
                    return true;
                }
                TextureVideoView textureVideoView = TextureVideoView.this;
                textureVideoView.resumePlayWhenReady = textureVideoView.isPlaying();
                TextureVideoView textureVideoView2 = TextureVideoView.this;
                textureVideoView2.resumePosMs = textureVideoView2.getCurrentPosition();
                if (TextureVideoView.this.prepared) {
                    TextureVideoView.this.pause();
                }
                TextureVideoView.this.playerOwner.clearSurfaceBlocking(surfaceTakeAttachedSurface);
                return true;
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureSizeChanged(SurfaceTexture st, int i3, int i4) {
                Intrinsics.checkNotNullParameter(st, "st");
                TextureVideoView.this.applySizing();
            }

            @Override // android.view.TextureView.SurfaceTextureListener
            public void onSurfaceTextureUpdated(SurfaceTexture st) {
                Intrinsics.checkNotNullParameter(st, "st");
                if (TextureVideoView.this.firstFrameRendered || !TextureVideoView.this.prepared) {
                    return;
                }
                TextureVideoView.this.firstFrameRendered = true;
                Function0 function0 = TextureVideoView.this.onReadyCallback;
                if (function0 != null) {
                    function0.invoke();
                }
            }
        });
        MediaController mediaController = new MediaController(context);
        mediaController.setMediaPlayer(this);
        if (z2) {
            mediaController.setAnchorView(this);
            mediaController.setEnabled(true);
        }
        this.controller = mediaController;
        setOnClickListener(new View.OnClickListener() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.video.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextureVideoView._init_$lambda$2(this.f92345a, view);
            }
        });
    }
}
