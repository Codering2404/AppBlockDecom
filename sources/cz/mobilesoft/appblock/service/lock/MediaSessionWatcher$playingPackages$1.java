package cz.mobilesoft.appblock.service.lock;

import android.media.session.MediaController;
import android.media.session.MediaSessionManager;
import android.media.session.PlaybackState;
import android.util.Log;
import cz.mobilesoft.coreblock.util.CrashHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ProducerScope;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.appblock.service.lock.MediaSessionWatcher$playingPackages$1", f = "MediaSessionWatcher.kt", l = {63, 111}, m = "invokeSuspend", v = 1)
final class MediaSessionWatcher$playingPackages$1 extends SuspendLambda implements Function2<ProducerScope<? super Set<? extends String>>, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f94821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f94822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object f94823c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f94824d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private /* synthetic */ Object f94825f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MediaSessionWatcher f94826g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MediaSessionWatcher$playingPackages$1(MediaSessionWatcher mediaSessionWatcher, Continuation continuation) {
        super(2, continuation);
        this.f94826g = mediaSessionWatcher;
    }

    private static final void K(List list, final MediaSessionWatcher mediaSessionWatcher, final ProducerScope producerScope, List list2) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((MediaController) pair.a()).unregisterCallback((MediaController.Callback) pair.b());
        }
        list.clear();
        mediaSessionWatcher.f94819d = list2;
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            MediaController mediaController = (MediaController) it2.next();
            MediaController.Callback callback = new MediaController.Callback() { // from class: cz.mobilesoft.appblock.service.lock.MediaSessionWatcher$playingPackages$1$bindTo$2$callback$1
                @Override // android.media.session.MediaController.Callback
                public void onPlaybackStateChanged(PlaybackState playbackState) {
                    MediaSessionWatcher$playingPackages$1.L(producerScope, mediaSessionWatcher);
                }

                @Override // android.media.session.MediaController.Callback
                public void onSessionDestroyed() {
                    MediaSessionWatcher$playingPackages$1.L(producerScope, mediaSessionWatcher);
                }
            };
            mediaController.registerCallback(callback, mediaSessionWatcher.f94818c);
            list.add(TuplesKt.a(mediaController, callback));
        }
        L(producerScope, mediaSessionWatcher);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(ProducerScope producerScope, MediaSessionWatcher mediaSessionWatcher) {
        List list = mediaSessionWatcher.f94819d;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            PlaybackState playbackState = ((MediaController) obj).getPlaybackState();
            if (playbackState != null && playbackState.getState() == 3) {
                arrayList.add(obj);
            }
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj2 = arrayList.get(i3);
            i3++;
            linkedHashSet.add(((MediaController) obj2).getPackageName());
        }
        producerScope.h(linkedHashSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit M() {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(List list, MediaSessionWatcher mediaSessionWatcher, ProducerScope producerScope, List list2) {
        if (list2 == null) {
            list2 = CollectionsKt.emptyList();
        }
        K(list, mediaSessionWatcher, producerScope, list2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(MediaSessionManager mediaSessionManager, MediaSessionManager.OnActiveSessionsChangedListener onActiveSessionsChangedListener, MediaSessionWatcher mediaSessionWatcher, ProducerScope producerScope, List list) {
        try {
            mediaSessionManager.addOnActiveSessionsChangedListener(onActiveSessionsChangedListener, mediaSessionWatcher.f94817b, mediaSessionWatcher.f94818c);
            List<MediaController> activeSessions = mediaSessionManager.getActiveSessions(mediaSessionWatcher.f94817b);
            Intrinsics.checkNotNullExpressionValue(activeSessions, "getActiveSessions(...)");
            K(list, mediaSessionWatcher, producerScope, activeSessions);
        } catch (SecurityException e3) {
            Log.w("MediaSessionWatcher", "Media sessions are not available", e3);
            producerScope.h(SetsKt.emptySet());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit S(final MediaSessionWatcher mediaSessionWatcher, final List list, final MediaSessionManager mediaSessionManager, final MediaSessionManager.OnActiveSessionsChangedListener onActiveSessionsChangedListener) {
        mediaSessionWatcher.f94818c.post(new Runnable() { // from class: cz.mobilesoft.appblock.service.lock.g
            @Override // java.lang.Runnable
            public final void run() {
                MediaSessionWatcher$playingPackages$1.T(list, mediaSessionWatcher, mediaSessionManager, onActiveSessionsChangedListener);
            }
        });
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(List list, MediaSessionWatcher mediaSessionWatcher, MediaSessionManager mediaSessionManager, MediaSessionManager.OnActiveSessionsChangedListener onActiveSessionsChangedListener) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            ((MediaController) pair.a()).unregisterCallback((MediaController.Callback) pair.b());
        }
        list.clear();
        mediaSessionWatcher.f94819d = CollectionsKt.emptyList();
        try {
            mediaSessionManager.removeOnActiveSessionsChangedListener(onActiveSessionsChangedListener);
        } catch (Exception e3) {
            CrashHelper.j(e3);
        }
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final Object invoke(ProducerScope producerScope, Continuation continuation) {
        return ((MediaSessionWatcher$playingPackages$1) create(producerScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        MediaSessionWatcher$playingPackages$1 mediaSessionWatcher$playingPackages$1 = new MediaSessionWatcher$playingPackages$1(this.f94826g, continuation);
        mediaSessionWatcher$playingPackages$1.f94825f = obj;
        return mediaSessionWatcher$playingPackages$1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x005d, code lost:
    
        if (kotlinx.coroutines.channels.ProduceKt.a(r5, r1, r9) == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0095, code lost:
    
        if (kotlinx.coroutines.channels.ProduceKt.a(r5, r1, r9) == r0) goto L19;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f94825f
            r5 = r0
            kotlinx.coroutines.channels.ProducerScope r5 = (kotlinx.coroutines.channels.ProducerScope) r5
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r9.f94824d
            r7 = 2
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 == r2) goto L2c
            if (r1 != r7) goto L24
            java.lang.Object r0 = r9.f94823c
            android.media.session.MediaSessionManager$OnActiveSessionsChangedListener r0 = (android.media.session.MediaSessionManager.OnActiveSessionsChangedListener) r0
            java.lang.Object r0 = r9.f94822b
            java.util.List r0 = (java.util.List) r0
            java.lang.Object r0 = r9.f94821a
            android.media.session.MediaSessionManager r0 = (android.media.session.MediaSessionManager) r0
            kotlin.ResultKt.b(r10)
            goto L98
        L24:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L2c:
            java.lang.Object r0 = r9.f94821a
            android.media.session.MediaSessionManager r0 = (android.media.session.MediaSessionManager) r0
            kotlin.ResultKt.b(r10)
            goto L60
        L34:
            kotlin.ResultKt.b(r10)
            cz.mobilesoft.appblock.service.lock.MediaSessionWatcher r10 = r9.f94826g
            android.content.Context r10 = cz.mobilesoft.appblock.service.lock.MediaSessionWatcher.b(r10)
            java.lang.Class<android.media.session.MediaSessionManager> r1 = android.media.session.MediaSessionManager.class
            java.lang.Object r10 = r10.getSystemService(r1)
            android.media.session.MediaSessionManager r10 = (android.media.session.MediaSessionManager) r10
            if (r10 != 0) goto L63
            java.util.Set r1 = kotlin.collections.SetsKt.emptySet()
            r5.h(r1)
            cz.mobilesoft.appblock.service.lock.c r1 = new cz.mobilesoft.appblock.service.lock.c
            r1.<init>()
            r9.f94825f = r5
            r9.f94821a = r10
            r9.f94824d = r2
            java.lang.Object r10 = kotlinx.coroutines.channels.ProduceKt.a(r5, r1, r9)
            if (r10 != r0) goto L60
            goto L97
        L60:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        L63:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            cz.mobilesoft.appblock.service.lock.MediaSessionWatcher r1 = r9.f94826g
            cz.mobilesoft.appblock.service.lock.d r3 = new cz.mobilesoft.appblock.service.lock.d
            r3.<init>()
            cz.mobilesoft.appblock.service.lock.MediaSessionWatcher r1 = r9.f94826g
            android.os.Handler r8 = cz.mobilesoft.appblock.service.lock.MediaSessionWatcher.a(r1)
            cz.mobilesoft.appblock.service.lock.MediaSessionWatcher r4 = r9.f94826g
            cz.mobilesoft.appblock.service.lock.e r1 = new cz.mobilesoft.appblock.service.lock.e
            r2 = r10
            r1.<init>()
            r8.post(r1)
            cz.mobilesoft.appblock.service.lock.MediaSessionWatcher r10 = r9.f94826g
            cz.mobilesoft.appblock.service.lock.f r1 = new cz.mobilesoft.appblock.service.lock.f
            r1.<init>()
            r9.f94825f = r5
            r9.f94821a = r2
            r9.f94822b = r6
            r9.f94823c = r3
            r9.f94824d = r7
            java.lang.Object r10 = kotlinx.coroutines.channels.ProduceKt.a(r5, r1, r9)
            if (r10 != r0) goto L98
        L97:
            return r0
        L98:
            kotlin.Unit r10 = kotlin.Unit.f139807a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.appblock.service.lock.MediaSessionWatcher$playingPackages$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
