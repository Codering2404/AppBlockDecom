package com.superwall.sdk.analytics;

import android.os.Build;
import com.revenuecat.purchases.ui.revenuecatui.templates.VWmQ.cJfnYMIyomoWf;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

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
public final class CPUInfo {
    private static final String CPU_INFO_DIR = "/sys/devices/system/cpu/";
    public static final Companion Companion = new Companion(null);

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
    @Serializable
    public static final class Data {
        private final List<Core> cores;
        public static final Companion Companion = new Companion(null);
        private static final KSerializer<Object>[] $childSerializers = {new ArrayListSerializer(CPUInfo$Data$Core$$serializer.INSTANCE)};

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<Data> serializer() {
                return CPUInfo$Data$$serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @Serializable
        public static final class Core {
            public static final Companion Companion = new Companion(null);
            private final long currentFreq;
            private final long maxFreq;
            private final long minFreq;
            private final int number;

            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class Companion {
                private Companion() {
                }

                public final KSerializer<Core> serializer() {
                    return CPUInfo$Data$Core$$serializer.INSTANCE;
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public /* synthetic */ Core(int i3, int i4, long j3, long j4, long j5, SerializationConstructorMarker serializationConstructorMarker) {
                if (15 != (i3 & 15)) {
                    PluginExceptionsKt.b(i3, 15, CPUInfo$Data$Core$$serializer.INSTANCE.getDescriptor());
                }
                this.number = i4;
                this.currentFreq = j3;
                this.maxFreq = j4;
                this.minFreq = j5;
            }

            public static /* synthetic */ Core copy$default(Core core, int i3, long j3, long j4, long j5, int i4, Object obj) {
                if ((i4 & 1) != 0) {
                    i3 = core.number;
                }
                if ((i4 & 2) != 0) {
                    j3 = core.currentFreq;
                }
                if ((i4 & 4) != 0) {
                    j4 = core.maxFreq;
                }
                if ((i4 & 8) != 0) {
                    j5 = core.minFreq;
                }
                long j6 = j5;
                return core.copy(i3, j3, j4, j6);
            }

            @JvmStatic
            public static final /* synthetic */ void write$Self$superwall_release(Core core, CompositeEncoder compositeEncoder, SerialDescriptor serialDescriptor) {
                compositeEncoder.w(serialDescriptor, 0, core.number);
                compositeEncoder.F(serialDescriptor, 1, core.currentFreq);
                compositeEncoder.F(serialDescriptor, 2, core.maxFreq);
                compositeEncoder.F(serialDescriptor, 3, core.minFreq);
            }

            public final int component1() {
                return this.number;
            }

            public final long component2() {
                return this.currentFreq;
            }

            public final long component3() {
                return this.maxFreq;
            }

            public final long component4() {
                return this.minFreq;
            }

            public final Core copy(int i3, long j3, long j4, long j5) {
                return new Core(i3, j3, j4, j5);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Core)) {
                    return false;
                }
                Core core = (Core) obj;
                return this.number == core.number && this.currentFreq == core.currentFreq && this.maxFreq == core.maxFreq && this.minFreq == core.minFreq;
            }

            public final long getCurrentFreq() {
                return this.currentFreq;
            }

            public final long getMaxFreq() {
                return this.maxFreq;
            }

            public final long getMinFreq() {
                return this.minFreq;
            }

            public final int getNumber() {
                return this.number;
            }

            public int hashCode() {
                return (((((Integer.hashCode(this.number) * 31) + Long.hashCode(this.currentFreq)) * 31) + Long.hashCode(this.maxFreq)) * 31) + Long.hashCode(this.minFreq);
            }

            public String toString() {
                return "#" + this.number + ", current: " + this.currentFreq + ", max: " + this.maxFreq + ", min: " + this.minFreq;
            }

            public Core(int i3, long j3, long j4, long j5) {
                this.number = i3;
                this.currentFreq = j3;
                this.maxFreq = j4;
                this.minFreq = j5;
            }
        }

        public /* synthetic */ Data(int i3, List list, SerializationConstructorMarker serializationConstructorMarker) {
            if (1 != (i3 & 1)) {
                PluginExceptionsKt.b(i3, 1, CPUInfo$Data$$serializer.INSTANCE.getDescriptor());
            }
            this.cores = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Data copy$default(Data data, List list, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                list = data.cores;
            }
            return data.copy(list);
        }

        public final List<Core> component1() {
            return this.cores;
        }

        public final Data copy(List<Core> cores) {
            Intrinsics.checkNotNullParameter(cores, "cores");
            return new Data(cores);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Data) && Intrinsics.areEqual(this.cores, ((Data) obj).cores);
        }

        public final List<Core> getCores() {
            return this.cores;
        }

        public int hashCode() {
            return this.cores.hashCode();
        }

        public String toString() {
            return "Cores: " + this.cores.size() + ": [" + CollectionsKt.joinToString$default(this.cores, null, null, null, 0, null, null, 63, null);
        }

        public Data(List<Core> cores) {
            Intrinsics.checkNotNullParameter(cores, "cores");
            this.cores = cores;
        }
    }

    public final String getAbi() {
        String str = Build.SUPPORTED_ABIS[0];
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final Data getCpuData() {
        getGetNumberOfCores();
        IntRange intRangeB = RangesKt.B(0, getGetNumberOfCores());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRangeB, 10));
        Iterator<Integer> it = intRangeB.iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            Pair<Long, Long> pairMinMaxFrequencyForCore = minMaxFrequencyForCore(iNextInt);
            arrayList.add(new Data.Core(iNextInt, frequencyForCore(iNextInt), ((Number) pairMinMaxFrequencyForCore.f()).longValue(), ((Number) pairMinMaxFrequencyForCore.e()).longValue()));
        }
        return new Data(arrayList);
    }

    public final int getGetNumberOfCores() {
        return Runtime.getRuntime().availableProcessors();
    }

    public final Pair<Long, Long> minMaxFrequencyForCore(int i3) {
        String str = "/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_min_freq";
        String str2 = "/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/cpuinfo_max_freq";
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(str, "r");
            try {
                String line = randomAccessFile.readLine();
                Intrinsics.checkNotNullExpressionValue(line, "readLine(...)");
                long j3 = 1000;
                long j4 = Long.parseLong(line) / j3;
                CloseableKt.a(randomAccessFile, null);
                randomAccessFile = new RandomAccessFile(str2, "r");
                try {
                    String line2 = randomAccessFile.readLine();
                    Intrinsics.checkNotNullExpressionValue(line2, "readLine(...)");
                    long j5 = Long.parseLong(line2) / j3;
                    CloseableKt.a(randomAccessFile, null);
                    return new Pair<>(Long.valueOf(j4), Long.valueOf(j5));
                } finally {
                }
            } finally {
                try {
                    throw th;
                } finally {
                }
            }
        } catch (Exception unused) {
            return new Pair<>(-1L, -1L);
        }
    }

    public final long frequencyForCore(int i3) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile("/sys/devices/system/cpu/cpu" + i3 + "/cpufreq/scaling_cur_freq", cJfnYMIyomoWf.tXpPFjRak);
            try {
                String line = randomAccessFile.readLine();
                Intrinsics.checkNotNullExpressionValue(line, "readLine(...)");
                long j3 = Long.parseLong(line) / ((long) 1000);
                CloseableKt.a(randomAccessFile, null);
                return j3;
            } finally {
            }
        } catch (Exception unused) {
            return -1L;
        }
    }
}
