package com.superwall.sdk.analytics;

import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.CPUInfo;
import com.superwall.sdk.misc.Either;
import com.superwall.sdk.utilities.ErrorTrackingKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

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
public final class DeviceClassifier implements ClassifierDataFactory {
    private final ClassifierDataFactory factory;
    private final Lazy videoCodecs$delegate;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Orientation {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Orientation[] $VALUES;
        public static final Orientation LANDSCAPE = new Orientation("LANDSCAPE", 0);
        public static final Orientation PORTRAIT = new Orientation("PORTRAIT", 1);
        public static final Orientation UNDEFINED = new Orientation("UNDEFINED", 2);

        private static final /* synthetic */ Orientation[] $values() {
            return new Orientation[]{LANDSCAPE, PORTRAIT, UNDEFINED};
        }

        static {
            Orientation[] orientationArr$values = $values();
            $VALUES = orientationArr$values;
            $ENTRIES = EnumEntriesKt.a(orientationArr$values);
        }

        private Orientation(String str, int i3) {
        }

        public static EnumEntries<Orientation> getEntries() {
            return $ENTRIES;
        }

        public static Orientation valueOf(String str) {
            return (Orientation) Enum.valueOf(Orientation.class, str);
        }

        public static Orientation[] values() {
            return (Orientation[]) $VALUES.clone();
        }
    }

    public DeviceClassifier(ClassifierDataFactory factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factory = factory;
        this.videoCodecs$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.analytics.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DeviceClassifier.videoCodecs_delegate$lambda$1(this.f93453a);
            }
        });
    }

    private final int cpuScore() {
        if (getCpuInfo().getCores().isEmpty()) {
            return -1;
        }
        List<CPUInfo.Data.Core> cores = getCpuInfo().getCores();
        if ((cores instanceof Collection) && cores.isEmpty()) {
            return -1;
        }
        Iterator<T> it = cores.iterator();
        while (it.hasNext()) {
            if (((CPUInfo.Data.Core) it.next()).getCurrentFreq() >= 0) {
                List<CPUInfo.Data.Core> cores2 = getCpuInfo().getCores();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(cores2, 10));
                Iterator<T> it2 = cores2.iterator();
                while (it2.hasNext()) {
                    arrayList.add(Long.valueOf(((CPUInfo.Data.Core) it2.next()).getMaxFreq()));
                }
                double dAverageOfLong = CollectionsKt.averageOfLong(arrayList) / 1000000.0d;
                if (dAverageOfLong > 1000.0d) {
                    dAverageOfLong /= (double) 1000;
                }
                int size = arrayList.size();
                return (int) (RangesKt.i(((double) size) / 8.0d, 1.0d) * RangesKt.i(dAverageOfLong / 4.0d, 1.0d) * ((double) 35));
            }
        }
        return -1;
    }

    private final int displayScore() {
        double screenWidth = getScreenWidth();
        double screenHeight = getScreenHeight();
        return (int) (RangesKt.i((Math.sqrt((screenWidth * screenWidth) + (screenHeight * screenHeight)) / getScreenSize()) / 500.0d, 1.0d) * ((double) 20));
    }

    private final List<String> getVideoCodecs() {
        return (List) this.videoCodecs$delegate.getValue();
    }

    private final int memScore() {
        return (int) (RangesKt.i((advertisedMemory() / 1.073741824E9d) / 10.0d, 1.0d) * ((double) 25));
    }

    private final int primeFreqBonus() {
        int i3;
        List<CPUInfo.Data.Core> cores = getCpuInfo().getCores();
        if ((cores instanceof Collection) && cores.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it = cores.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (((CPUInfo.Data.Core) it.next()).getMaxFreq() >= 3500000 && (i3 = i3 + 1) < 0) {
                    CollectionsKt.throwCountOverflow();
                }
            }
        }
        return i3 >= getCpuInfo().getCores().size() / 3 ? 5 : 0;
    }

    private final Either<Integer, Throwable> totalScore() {
        try {
            int iCpuScore = cpuScore();
            int iPrimeFreqBonus = primeFreqBonus() + memScore() + videoScore() + displayScore();
            return new Either.Success(Integer.valueOf(iCpuScore == -1 ? (iPrimeFreqBonus * 100) / 65 : iPrimeFreqBonus + iCpuScore));
        } catch (Throwable th) {
            if (ErrorTrackingKt.shouldLog(th)) {
                Superwall.Companion companion = Superwall.Companion;
                if (companion.getInitialized()) {
                    ErrorTrackingKt.trackError(companion.getInstance(), th);
                }
            }
            return new Either.Failure(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List videoCodecs_delegate$lambda$1(DeviceClassifier deviceClassifier) {
        List<String> listCodecs = deviceClassifier.codecs();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listCodecs) {
            if (StringsKt.a0((String) obj, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_VIDEO, false, 2, null)) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final int videoScore() {
        int i3;
        List<String> videoCodecs = getVideoCodecs();
        if ((videoCodecs instanceof Collection) && videoCodecs.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it = videoCodecs.iterator();
            while (it.hasNext()) {
                if (StringsKt.Y((String) it.next(), "av01", true)) {
                    i3 = 10;
                    break;
                }
            }
            i3 = 0;
        }
        List<String> videoCodecs2 = getVideoCodecs();
        if (!(videoCodecs2 instanceof Collection) || !videoCodecs2.isEmpty()) {
            Iterator<T> it2 = videoCodecs2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                if (StringsKt.Y((String) it2.next(), "hevc", true)) {
                    i3 += 14;
                    break;
                }
            }
        }
        List<String> videoCodecs3 = getVideoCodecs();
        if (!(videoCodecs3 instanceof Collection) || !videoCodecs3.isEmpty()) {
            Iterator<T> it3 = videoCodecs3.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    break;
                }
                if (StringsKt.Y((String) it3.next(), "vp9", true)) {
                    i3 += 6;
                    break;
                }
            }
        }
        List<String> videoCodecs4 = getVideoCodecs();
        if (!(videoCodecs4 instanceof Collection) || !videoCodecs4.isEmpty()) {
            Iterator<T> it4 = videoCodecs4.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                if (StringsKt.Y((String) it4.next(), "vp8", true)) {
                    i3 += 4;
                    break;
                }
            }
        }
        return RangesKt.k(i3, 20);
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public long advertisedMemory() {
        return this.factory.advertisedMemory();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public List<String> codecs() {
        return this.factory.codecs();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public Context context() {
        return this.factory.context();
    }

    public final Tier deviceTier() {
        Integer success = totalScore().getSuccess();
        return success == null ? Tier.UNKNOWN : new IntRange(0, 24).p(success.intValue()) ? Tier.ULTRA_LOW : new IntRange(25, 44).p(success.intValue()) ? Tier.LOW : new IntRange(45, 69).p(success.intValue()) ? Tier.MID : new IntRange(70, 85).p(success.intValue()) ? Tier.HIGH : Tier.ULTRA_HIGH;
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public CPUInfo.Data getCpuInfo() {
        return this.factory.getCpuInfo();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public Orientation getOrientation() {
        return this.factory.getOrientation();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public int getScreenHeight() {
        return this.factory.getScreenHeight();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public double getScreenSize() {
        return this.factory.getScreenSize();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public int getScreenWidth() {
        return this.factory.getScreenWidth();
    }

    @Override // com.superwall.sdk.analytics.ClassifierDataFactory
    public boolean isTabletMinWidth() {
        return this.factory.isTabletMinWidth();
    }
}
