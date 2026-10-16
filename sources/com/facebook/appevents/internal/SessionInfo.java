package com.facebook.appevents.internal;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;
import java.util.UUID;
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
public final class SessionInfo {
    public static final Companion Companion = new Companion(null);
    private static final String INTERRUPTION_COUNT_KEY = "com.facebook.appevents.SessionInfo.interruptionCount";
    private static final String LAST_SESSION_INFO_END_KEY = "com.facebook.appevents.SessionInfo.sessionEndTime";
    private static final String LAST_SESSION_INFO_START_KEY = "com.facebook.appevents.SessionInfo.sessionStartTime";
    private static final String SESSION_ID_KEY = "com.facebook.appevents.SessionInfo.sessionId";
    private Long diskRestoreTime;
    private int interruptionCount;
    private UUID sessionId;
    private Long sessionLastEventTime;
    private final Long sessionStartTime;
    private SourceApplicationInfo sourceApplicationInfo;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void clearSavedSessionFromDisk() {
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
            editorEdit.remove(SessionInfo.LAST_SESSION_INFO_START_KEY);
            editorEdit.remove(SessionInfo.LAST_SESSION_INFO_END_KEY);
            editorEdit.remove(SessionInfo.INTERRUPTION_COUNT_KEY);
            editorEdit.remove(SessionInfo.SESSION_ID_KEY);
            editorEdit.apply();
            SourceApplicationInfo.Companion.clearSavedSourceApplicationInfoFromDisk();
        }

        @JvmStatic
        public final SessionInfo getStoredSessionInfo() {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
            long j3 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_START_KEY, 0L);
            long j4 = defaultSharedPreferences.getLong(SessionInfo.LAST_SESSION_INFO_END_KEY, 0L);
            String string = defaultSharedPreferences.getString(SessionInfo.SESSION_ID_KEY, null);
            if (j3 == 0 || j4 == 0 || string == null) {
                return null;
            }
            SessionInfo sessionInfo = new SessionInfo(Long.valueOf(j3), Long.valueOf(j4), null, 4, null);
            sessionInfo.interruptionCount = defaultSharedPreferences.getInt(SessionInfo.INTERRUPTION_COUNT_KEY, 0);
            sessionInfo.setSourceApplicationInfo(SourceApplicationInfo.Companion.getStoredSourceApplicatioInfo());
            sessionInfo.setDiskRestoreTime(Long.valueOf(System.currentTimeMillis()));
            UUID uuidFromString = UUID.fromString(string);
            Intrinsics.checkNotNullExpressionValue(uuidFromString, "fromString(sessionIDStr)");
            sessionInfo.setSessionId(uuidFromString);
            return sessionInfo;
        }

        private Companion() {
        }
    }

    public SessionInfo(Long l3, Long l4) {
        this(l3, l4, null, 4, null);
    }

    @JvmStatic
    public static final void clearSavedSessionFromDisk() {
        Companion.clearSavedSessionFromDisk();
    }

    @JvmStatic
    public static final SessionInfo getStoredSessionInfo() {
        return Companion.getStoredSessionInfo();
    }

    public final Long getDiskRestoreTime() {
        Long l3 = this.diskRestoreTime;
        if (l3 == null) {
            return 0L;
        }
        return l3;
    }

    public final int getInterruptionCount() {
        return this.interruptionCount;
    }

    public final UUID getSessionId() {
        return this.sessionId;
    }

    public final Long getSessionLastEventTime() {
        return this.sessionLastEventTime;
    }

    public final long getSessionLength() {
        Long l3;
        if (this.sessionStartTime == null || (l3 = this.sessionLastEventTime) == null) {
            return 0L;
        }
        if (l3 != null) {
            return l3.longValue() - this.sessionStartTime.longValue();
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final Long getSessionStartTime() {
        return this.sessionStartTime;
    }

    public final SourceApplicationInfo getSourceApplicationInfo() {
        return this.sourceApplicationInfo;
    }

    public final void incrementInterruptionCount() {
        this.interruptionCount++;
    }

    public final void setDiskRestoreTime(Long l3) {
        this.diskRestoreTime = l3;
    }

    public final void setSessionId(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<set-?>");
        this.sessionId = uuid;
    }

    public final void setSessionLastEventTime(Long l3) {
        this.sessionLastEventTime = l3;
    }

    public final void setSourceApplicationInfo(SourceApplicationInfo sourceApplicationInfo) {
        this.sourceApplicationInfo = sourceApplicationInfo;
    }

    public final void writeSessionToDisk() {
        SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        Long l3 = this.sessionStartTime;
        editorEdit.putLong(LAST_SESSION_INFO_START_KEY, l3 != null ? l3.longValue() : 0L);
        Long l4 = this.sessionLastEventTime;
        editorEdit.putLong(LAST_SESSION_INFO_END_KEY, l4 != null ? l4.longValue() : 0L);
        editorEdit.putInt(INTERRUPTION_COUNT_KEY, this.interruptionCount);
        editorEdit.putString(SESSION_ID_KEY, this.sessionId.toString());
        editorEdit.apply();
        SourceApplicationInfo sourceApplicationInfo = this.sourceApplicationInfo;
        if (sourceApplicationInfo == null || sourceApplicationInfo == null) {
            return;
        }
        sourceApplicationInfo.writeSourceApplicationInfoToDisk();
    }

    public SessionInfo(Long l3, Long l4, UUID sessionId) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.sessionStartTime = l3;
        this.sessionLastEventTime = l4;
        this.sessionId = sessionId;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ SessionInfo(Long l3, Long l4, UUID uuid, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        if ((i3 & 4) != 0) {
            uuid = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID()");
        }
        this(l3, l4, uuid);
    }
}
