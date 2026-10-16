package com.facebook.internal;

import android.content.Intent;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class CallbackManagerImpl implements CallbackManager {
    public static final Companion Companion = new Companion(null);
    private static final Map<Integer, Callback> staticCallbacks = new HashMap();
    private final Map<Integer, Callback> callbacks = new HashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Callback {
        boolean onActivityResult(int i3, Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final synchronized Callback getStaticCallback(int i3) {
            return (Callback) CallbackManagerImpl.staticCallbacks.get(Integer.valueOf(i3));
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final boolean runStaticCallback(int i3, int i4, Intent intent) {
            Callback staticCallback = getStaticCallback(i3);
            if (staticCallback != null) {
                return staticCallback.onActivityResult(i4, intent);
            }
            return false;
        }

        @JvmStatic
        public final synchronized void registerStaticCallback(int i3, Callback callback) {
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (CallbackManagerImpl.staticCallbacks.containsKey(Integer.valueOf(i3))) {
                return;
            }
            CallbackManagerImpl.staticCallbacks.put(Integer.valueOf(i3), callback);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public enum RequestCodeOffset {
        Login(0),
        Share(1),
        Message(2),
        Like(3),
        GameRequest(4),
        AppGroupCreate(5),
        AppGroupJoin(6),
        AppInvite(7),
        DeviceShare(8),
        GamingFriendFinder(9),
        GamingGroupIntegration(10),
        Referral(11),
        GamingContextCreate(12),
        GamingContextSwitch(13),
        GamingContextChoose(14),
        TournamentShareDialog(15),
        TournamentJoinDialog(16);

        private final int offset;

        RequestCodeOffset(int i3) {
            this.offset = i3;
        }

        public final int toRequestCode() {
            return FacebookSdk.getCallbackRequestCodeOffset() + this.offset;
        }
    }

    @JvmStatic
    private static final synchronized Callback getStaticCallback(int i3) {
        return Companion.getStaticCallback(i3);
    }

    @JvmStatic
    public static final synchronized void registerStaticCallback(int i3, Callback callback) {
        Companion.registerStaticCallback(i3, callback);
    }

    @JvmStatic
    private static final boolean runStaticCallback(int i3, int i4, Intent intent) {
        return Companion.runStaticCallback(i3, i4, intent);
    }

    @Override // com.facebook.CallbackManager
    public boolean onActivityResult(int i3, int i4, Intent intent) {
        Callback callback = this.callbacks.get(Integer.valueOf(i3));
        return callback != null ? callback.onActivityResult(i4, intent) : Companion.runStaticCallback(i3, i4, intent);
    }

    public final void registerCallback(int i3, Callback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callbacks.put(Integer.valueOf(i3), callback);
    }

    public final void unregisterCallback(int i3) {
        this.callbacks.remove(Integer.valueOf(i3));
    }
}
