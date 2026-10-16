package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public final class LogEnvironment implements NumberedEnum {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LogEnvironment f89988b = new LogEnvironment("LOG_ENVIRONMENT_UNKNOWN", 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LogEnvironment f89989c = new LogEnvironment("LOG_ENVIRONMENT_AUTOPUSH", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LogEnvironment f89990d = new LogEnvironment("LOG_ENVIRONMENT_STAGING", 2, 2);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LogEnvironment f89991f = new LogEnvironment("LOG_ENVIRONMENT_PROD", 3, 3);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final /* synthetic */ LogEnvironment[] f89992g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f89993h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89994a;

    static {
        LogEnvironment[] logEnvironmentArrA = a();
        f89992g = logEnvironmentArrA;
        f89993h = EnumEntriesKt.a(logEnvironmentArrA);
    }

    private LogEnvironment(String str, int i3, int i4) {
        this.f89994a = i4;
    }

    private static final /* synthetic */ LogEnvironment[] a() {
        return new LogEnvironment[]{f89988b, f89989c, f89990d, f89991f};
    }

    public static LogEnvironment valueOf(String str) {
        return (LogEnvironment) Enum.valueOf(LogEnvironment.class, str);
    }

    public static LogEnvironment[] values() {
        return (LogEnvironment[]) f89992g.clone();
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int J() {
        return this.f89994a;
    }
}
