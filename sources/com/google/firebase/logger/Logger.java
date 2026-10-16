package com.google.firebase.logger;

import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes6.dex */
@Metadata
public abstract class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f89335a = new Companion(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap f89336b = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class AndroidLogger extends Logger {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public /* synthetic */ class WhenMappings {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f89337a;

            static {
                int[] iArr = new int[Level.values().length];
                try {
                    iArr[Level.f89338b.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Level.f89339c.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Level.f89340d.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Level.f89341f.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[Level.f89342g.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                f89337a = iArr;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class FakeLogger extends Logger {
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Level {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Level f89338b = new Level("VERBOSE", 0, 2);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Level f89339c = new Level("DEBUG", 1, 3);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Level f89340d = new Level("INFO", 2, 4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final Level f89341f = new Level("WARN", 3, 5);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final Level f89342g = new Level("ERROR", 4, 6);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private static final /* synthetic */ Level[] f89343h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private static final /* synthetic */ EnumEntries f89344i;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f89345a;

        static {
            Level[] levelArrA = a();
            f89343h = levelArrA;
            f89344i = EnumEntriesKt.a(levelArrA);
        }

        private Level(String str, int i3, int i4) {
            this.f89345a = i4;
        }

        private static final /* synthetic */ Level[] a() {
            return new Level[]{f89338b, f89339c, f89340d, f89341f, f89342g};
        }

        public static Level valueOf(String str) {
            return (Level) Enum.valueOf(Level.class, str);
        }

        public static Level[] values() {
            return (Level[]) f89343h.clone();
        }
    }
}
