package com.sun.jna;

import coil.target.Yb.oUcQRqOVfOC;
import com.applovin.exoplayer2.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes7.dex */
class ELFAnalyser {
    private static final int EF_ARM_ABI_FLOAT_HARD = 1024;
    private static final int EF_ARM_ABI_FLOAT_SOFT = 512;
    private static final int EI_CLASS_64BIT = 2;
    private static final int EI_DATA_BIG_ENDIAN = 2;
    private static final byte[] ELF_MAGIC = {Ascii.DEL, 69, 76, 70};
    private static final int E_MACHINE_ARM = 40;
    private static final int SHN_UNDEF = 0;
    private static final int SHN_XINDEX = 65535;
    private final String filename;
    private boolean ELF = false;
    private boolean _64Bit = false;
    private boolean bigEndian = false;
    private boolean armHardFloatFlag = false;
    private boolean armSoftFloatFlag = false;
    private boolean armEabiAapcsVfp = false;
    private boolean arm = false;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ArmAeabiAttributesTag {
        public static final ArmAeabiAttributesTag ABI_FP_16bit_format;
        public static final ArmAeabiAttributesTag ABI_FP_denormal;
        public static final ArmAeabiAttributesTag ABI_FP_exceptions;
        public static final ArmAeabiAttributesTag ABI_FP_number_model;
        public static final ArmAeabiAttributesTag ABI_FP_optimization_goals;
        public static final ArmAeabiAttributesTag ABI_FP_rounding;
        public static final ArmAeabiAttributesTag ABI_FP_user_exceptions;
        public static final ArmAeabiAttributesTag ABI_HardFP_use;
        public static final ArmAeabiAttributesTag ABI_PCS_GOT_use;
        public static final ArmAeabiAttributesTag ABI_PCS_R9_use;
        public static final ArmAeabiAttributesTag ABI_PCS_RO_data;
        public static final ArmAeabiAttributesTag ABI_PCS_RW_data;
        public static final ArmAeabiAttributesTag ABI_PCS_wchar_t;
        public static final ArmAeabiAttributesTag ABI_VFP_args;
        public static final ArmAeabiAttributesTag ABI_WMMX_args;
        public static final ArmAeabiAttributesTag ABI_align8_preserved;
        public static final ArmAeabiAttributesTag ABI_align_needed;
        public static final ArmAeabiAttributesTag ABI_enum_size;
        public static final ArmAeabiAttributesTag ABI_optimization_goals;
        public static final ArmAeabiAttributesTag ARM_ISA_use;
        public static final ArmAeabiAttributesTag Advanced_SIMD_arch;
        public static final ArmAeabiAttributesTag CPU_arch;
        public static final ArmAeabiAttributesTag CPU_arch_profile;
        public static final ArmAeabiAttributesTag CPU_name;
        public static final ArmAeabiAttributesTag CPU_raw_name;
        public static final ArmAeabiAttributesTag CPU_unaligned_access;
        public static final ArmAeabiAttributesTag DIV_use;
        public static final ArmAeabiAttributesTag FP_HP_extension;
        public static final ArmAeabiAttributesTag FP_arch;
        public static final ArmAeabiAttributesTag File;
        public static final ArmAeabiAttributesTag MPextension_use;
        public static final ArmAeabiAttributesTag MPextension_use2;
        public static final ArmAeabiAttributesTag PCS_config;
        public static final ArmAeabiAttributesTag Section;
        public static final ArmAeabiAttributesTag Symbol;
        public static final ArmAeabiAttributesTag T2EE_use;
        public static final ArmAeabiAttributesTag THUMB_ISA_use;
        public static final ArmAeabiAttributesTag Virtualization_use;
        public static final ArmAeabiAttributesTag WMMX_arch;
        public static final ArmAeabiAttributesTag also_compatible_with;
        public static final ArmAeabiAttributesTag compatibility;
        public static final ArmAeabiAttributesTag conformance;
        public static final ArmAeabiAttributesTag nodefaults;
        private final String name;
        private final ParameterType parameterType;
        private final int value;
        private static final List<ArmAeabiAttributesTag> tags = new LinkedList();
        private static final Map<Integer, ArmAeabiAttributesTag> valueMap = new HashMap();
        private static final Map<String, ArmAeabiAttributesTag> nameMap = new HashMap();

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public enum ParameterType {
            UINT32,
            NTBS,
            ULEB128
        }

        public ArmAeabiAttributesTag(int i3, String str, ParameterType parameterType) {
            this.value = i3;
            this.name = str;
            this.parameterType = parameterType;
        }

        private static ArmAeabiAttributesTag addTag(int i3, String str, ParameterType parameterType) {
            ArmAeabiAttributesTag armAeabiAttributesTag = new ArmAeabiAttributesTag(i3, str, parameterType);
            Map<Integer, ArmAeabiAttributesTag> map = valueMap;
            if (!map.containsKey(Integer.valueOf(armAeabiAttributesTag.getValue()))) {
                map.put(Integer.valueOf(armAeabiAttributesTag.getValue()), armAeabiAttributesTag);
            }
            Map<String, ArmAeabiAttributesTag> map2 = nameMap;
            if (!map2.containsKey(armAeabiAttributesTag.getName())) {
                map2.put(armAeabiAttributesTag.getName(), armAeabiAttributesTag);
            }
            tags.add(armAeabiAttributesTag);
            return armAeabiAttributesTag;
        }

        public static ArmAeabiAttributesTag getByName(String str) {
            return nameMap.get(str);
        }

        public static ArmAeabiAttributesTag getByValue(int i3) {
            Map<Integer, ArmAeabiAttributesTag> map = valueMap;
            if (map.containsKey(Integer.valueOf(i3))) {
                return map.get(Integer.valueOf(i3));
            }
            return new ArmAeabiAttributesTag(i3, "Unknown " + i3, getParameterType(i3));
        }

        public static List<ArmAeabiAttributesTag> getTags() {
            return Collections.unmodifiableList(tags);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.value == ((ArmAeabiAttributesTag) obj).value;
        }

        public String getName() {
            return this.name;
        }

        public ParameterType getParameterType() {
            return this.parameterType;
        }

        public int getValue() {
            return this.value;
        }

        public int hashCode() {
            return 469 + this.value;
        }

        public String toString() {
            return this.name + " (" + this.value + ")";
        }

        static {
            ParameterType parameterType = ParameterType.UINT32;
            File = addTag(1, "File", parameterType);
            Section = addTag(2, "Section", parameterType);
            Symbol = addTag(3, "Symbol", parameterType);
            ParameterType parameterType2 = ParameterType.NTBS;
            CPU_raw_name = addTag(4, "CPU_raw_name", parameterType2);
            CPU_name = addTag(5, "CPU_name", parameterType2);
            ParameterType parameterType3 = ParameterType.ULEB128;
            CPU_arch = addTag(6, "CPU_arch", parameterType3);
            CPU_arch_profile = addTag(7, "CPU_arch_profile", parameterType3);
            ARM_ISA_use = addTag(8, "ARM_ISA_use", parameterType3);
            THUMB_ISA_use = addTag(9, "THUMB_ISA_use", parameterType3);
            FP_arch = addTag(10, "FP_arch", parameterType3);
            WMMX_arch = addTag(11, "WMMX_arch", parameterType3);
            Advanced_SIMD_arch = addTag(12, "Advanced_SIMD_arch", parameterType3);
            PCS_config = addTag(13, "PCS_config", parameterType3);
            ABI_PCS_R9_use = addTag(14, "ABI_PCS_R9_use", parameterType3);
            ABI_PCS_RW_data = addTag(15, "ABI_PCS_RW_data", parameterType3);
            ABI_PCS_RO_data = addTag(16, "ABI_PCS_RO_data", parameterType3);
            ABI_PCS_GOT_use = addTag(17, "ABI_PCS_GOT_use", parameterType3);
            ABI_PCS_wchar_t = addTag(18, "ABI_PCS_wchar_t", parameterType3);
            ABI_FP_rounding = addTag(19, "ABI_FP_rounding", parameterType3);
            ABI_FP_denormal = addTag(20, "ABI_FP_denormal", parameterType3);
            ABI_FP_exceptions = addTag(21, "ABI_FP_exceptions", parameterType3);
            ABI_FP_user_exceptions = addTag(22, "ABI_FP_user_exceptions", parameterType3);
            ABI_FP_number_model = addTag(23, "ABI_FP_number_model", parameterType3);
            ABI_align_needed = addTag(24, oUcQRqOVfOC.fEJVKHq, parameterType3);
            ABI_align8_preserved = addTag(25, "ABI_align8_preserved", parameterType3);
            ABI_enum_size = addTag(26, "ABI_enum_size", parameterType3);
            ABI_HardFP_use = addTag(27, "ABI_HardFP_use", parameterType3);
            ABI_VFP_args = addTag(28, "ABI_VFP_args", parameterType3);
            ABI_WMMX_args = addTag(29, "ABI_WMMX_args", parameterType3);
            ABI_optimization_goals = addTag(30, "ABI_optimization_goals", parameterType3);
            ABI_FP_optimization_goals = addTag(31, "ABI_FP_optimization_goals", parameterType3);
            compatibility = addTag(32, "compatibility", parameterType2);
            CPU_unaligned_access = addTag(34, "CPU_unaligned_access", parameterType3);
            FP_HP_extension = addTag(36, "FP_HP_extension", parameterType3);
            ABI_FP_16bit_format = addTag(38, "ABI_FP_16bit_format", parameterType3);
            MPextension_use = addTag(42, "MPextension_use", parameterType3);
            DIV_use = addTag(44, "DIV_use", parameterType3);
            nodefaults = addTag(64, "nodefaults", parameterType3);
            also_compatible_with = addTag(65, "also_compatible_with", parameterType2);
            conformance = addTag(67, "conformance", parameterType2);
            T2EE_use = addTag(66, "T2EE_use", parameterType3);
            Virtualization_use = addTag(68, "Virtualization_use", parameterType3);
            MPextension_use2 = addTag(70, "MPextension_use", parameterType3);
        }

        private static ParameterType getParameterType(int i3) {
            ArmAeabiAttributesTag byValue = getByValue(i3);
            return byValue == null ? i3 % 2 == 0 ? ParameterType.ULEB128 : ParameterType.NTBS : byValue.getParameterType();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ELFSectionHeaderEntry {
        private final long addr;
        private final long flags;
        private final int link;
        private String name;
        private final int nameOffset;
        private final long offset;
        private final long size;
        private final int type;

        public ELFSectionHeaderEntry(boolean z2, ByteBuffer byteBuffer) {
            this.nameOffset = byteBuffer.getInt(0);
            this.type = byteBuffer.getInt(4);
            this.flags = z2 ? byteBuffer.getLong(8) : byteBuffer.getInt(8);
            this.addr = z2 ? byteBuffer.getLong(16) : byteBuffer.getInt(12);
            this.offset = z2 ? byteBuffer.getLong(24) : byteBuffer.getInt(16);
            this.size = z2 ? byteBuffer.getLong(32) : byteBuffer.getInt(20);
            this.link = byteBuffer.getInt(z2 ? 40 : 24);
        }

        public long getAddr() {
            return this.addr;
        }

        public long getFlags() {
            return this.flags;
        }

        public int getLink() {
            return this.link;
        }

        public String getName() {
            return this.name;
        }

        public int getNameOffset() {
            return this.nameOffset;
        }

        public long getOffset() {
            return this.offset;
        }

        public long getSize() {
            return this.size;
        }

        public int getType() {
            return this.type;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String toString() {
            return String.format("ELFSectionHeaderEntry{nameOffset=%1$d (0x%1$x), name=%2$s, type=%3$d (0x%3$x), flags=%4$d (0x%4$x), addr=%5$d (0x%5$x), offset=%6$d (0x%6$x), size=%7$d (0x%7$x), link=%8$d (0x%8$x)}", Integer.valueOf(this.nameOffset), this.name, Integer.valueOf(this.type), Long.valueOf(this.flags), Long.valueOf(this.addr), Long.valueOf(this.offset), Long.valueOf(this.size), Integer.valueOf(this.link));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ELFSectionHeaders {
        private final List<ELFSectionHeaderEntry> entries = new ArrayList();

        public ELFSectionHeaders(boolean z2, boolean z3, ByteBuffer byteBuffer, RandomAccessFile randomAccessFile) throws IOException {
            long j3;
            short s2;
            short s3;
            int link;
            byte b3;
            if (z2) {
                j3 = byteBuffer.getLong(40);
                s2 = byteBuffer.getShort(58);
                s3 = byteBuffer.getShort(60);
                link = byteBuffer.getShort(62);
            } else {
                j3 = byteBuffer.getInt(32);
                s2 = byteBuffer.getShort(46);
                s3 = byteBuffer.getShort(48);
                link = byteBuffer.getShort(50);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(s2);
            randomAccessFile.getChannel().read(byteBufferAllocate, j3);
            ELFSectionHeaderEntry eLFSectionHeaderEntry = new ELFSectionHeaderEntry(z2, byteBufferAllocate);
            int size = (s3 != 0 || j3 == 0) ? s3 : (int) eLFSectionHeaderEntry.getSize();
            link = link == ELFAnalyser.SHN_XINDEX ? eLFSectionHeaderEntry.getLink() : link;
            int i3 = size * s2;
            if (i3 == 0 || link == 0) {
                return;
            }
            ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i3);
            byteBufferAllocate2.order(z3 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.getChannel().read(byteBufferAllocate2, j3);
            for (int i4 = 0; i4 < s3; i4++) {
                byteBufferAllocate2.position(i4 * s2);
                ByteBuffer byteBufferSlice = byteBufferAllocate2.slice();
                byteBufferSlice.order(byteBufferAllocate2.order());
                byteBufferSlice.limit(s2);
                this.entries.add(new ELFSectionHeaderEntry(z2, byteBufferSlice));
            }
            ELFSectionHeaderEntry eLFSectionHeaderEntry2 = this.entries.get(link);
            ByteBuffer byteBufferAllocate3 = ByteBuffer.allocate((int) eLFSectionHeaderEntry2.getSize());
            byteBufferAllocate3.order(z3 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            randomAccessFile.getChannel().read(byteBufferAllocate3, eLFSectionHeaderEntry2.getOffset());
            byteBufferAllocate3.rewind();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(20);
            for (ELFSectionHeaderEntry eLFSectionHeaderEntry3 : this.entries) {
                byteArrayOutputStream.reset();
                byteBufferAllocate3.position(eLFSectionHeaderEntry3.getNameOffset());
                while (byteBufferAllocate3.position() < byteBufferAllocate3.limit() && (b3 = byteBufferAllocate3.get()) != 0) {
                    byteArrayOutputStream.write(b3);
                }
                eLFSectionHeaderEntry3.setName(byteArrayOutputStream.toString("ASCII"));
            }
        }

        public List<ELFSectionHeaderEntry> getEntries() {
            return this.entries;
        }
    }

    private ELFAnalyser(String str) {
        this.filename = str;
    }

    public static ELFAnalyser analyse(String str) throws IOException {
        ELFAnalyser eLFAnalyser = new ELFAnalyser(str);
        eLFAnalyser.runDetection();
        return eLFAnalyser;
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseAEABI(ByteBuffer byteBuffer) {
        HashMap map = new HashMap();
        while (byteBuffer.position() < byteBuffer.limit()) {
            int iPosition = byteBuffer.position();
            int iIntValue = readULEB128(byteBuffer).intValue();
            int i3 = byteBuffer.getInt();
            if (iIntValue == 1) {
                map.put(Integer.valueOf(iIntValue), parseFileAttribute(byteBuffer));
            }
            byteBuffer.position(iPosition + i3);
        }
        return map;
    }

    private static Map<Integer, Map<ArmAeabiAttributesTag, Object>> parseArmAttributes(ByteBuffer byteBuffer) {
        if (byteBuffer.get() != 65) {
            return Collections.EMPTY_MAP;
        }
        while (byteBuffer.position() < byteBuffer.limit()) {
            int iPosition = byteBuffer.position();
            int i3 = byteBuffer.getInt();
            if (i3 <= 0) {
                break;
            }
            if ("aeabi".equals(readNTBS(byteBuffer, null))) {
                return parseAEABI(byteBuffer);
            }
            byteBuffer.position(iPosition + i3);
        }
        return Collections.EMPTY_MAP;
    }

    private void parseEabiAapcsVfp(ByteBuffer byteBuffer, RandomAccessFile randomAccessFile) throws IOException {
        for (ELFSectionHeaderEntry eLFSectionHeaderEntry : new ELFSectionHeaders(this._64Bit, this.bigEndian, byteBuffer, randomAccessFile).getEntries()) {
            if (".ARM.attributes".equals(eLFSectionHeaderEntry.getName())) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate((int) eLFSectionHeaderEntry.getSize());
                byteBufferAllocate.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
                randomAccessFile.getChannel().read(byteBufferAllocate, eLFSectionHeaderEntry.getOffset());
                byteBufferAllocate.rewind();
                Map<ArmAeabiAttributesTag, Object> map = parseArmAttributes(byteBufferAllocate).get(1);
                if (map != null) {
                    Object obj = map.get(ArmAeabiAttributesTag.ABI_VFP_args);
                    if ((obj instanceof Integer) && ((Integer) obj).equals(1)) {
                        this.armEabiAapcsVfp = true;
                    } else if ((obj instanceof BigInteger) && ((BigInteger) obj).intValue() == 1) {
                        this.armEabiAapcsVfp = true;
                    }
                }
            }
        }
    }

    private static Map<ArmAeabiAttributesTag, Object> parseFileAttribute(ByteBuffer byteBuffer) {
        HashMap map = new HashMap();
        while (byteBuffer.position() < byteBuffer.limit()) {
            ArmAeabiAttributesTag byValue = ArmAeabiAttributesTag.getByValue(readULEB128(byteBuffer).intValue());
            int iOrdinal = byValue.getParameterType().ordinal();
            if (iOrdinal == 0) {
                map.put(byValue, Integer.valueOf(byteBuffer.getInt()));
            } else if (iOrdinal == 1) {
                map.put(byValue, readNTBS(byteBuffer, null));
            } else if (iOrdinal == 2) {
                map.put(byValue, readULEB128(byteBuffer));
            }
        }
        return map;
    }

    private static String readNTBS(ByteBuffer byteBuffer, Integer num) {
        if (num != null) {
            byteBuffer.position(num.intValue());
        }
        int iPosition = byteBuffer.position();
        while (byteBuffer.get() != 0 && byteBuffer.position() <= byteBuffer.limit()) {
        }
        byte[] bArr = new byte[(byteBuffer.position() - iPosition) - 1];
        byteBuffer.position(iPosition);
        byteBuffer.get(bArr);
        byteBuffer.position(byteBuffer.position() + 1);
        try {
            return new String(bArr, "ASCII");
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static BigInteger readULEB128(ByteBuffer byteBuffer) {
        BigInteger bigIntegerOr = BigInteger.ZERO;
        int i3 = 0;
        while (true) {
            byte b3 = byteBuffer.get();
            bigIntegerOr = bigIntegerOr.or(BigInteger.valueOf(b3 & Ascii.DEL).shiftLeft(i3));
            if ((b3 & 128) == 0) {
                return bigIntegerOr;
            }
            i3 += 7;
        }
    }

    private void runDetection() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.filename, "r");
        try {
            boolean z2 = true;
            if (randomAccessFile.length() > 4) {
                byte[] bArr = new byte[4];
                randomAccessFile.seek(0L);
                randomAccessFile.read(bArr);
                if (Arrays.equals(bArr, ELF_MAGIC)) {
                    this.ELF = true;
                }
            }
            if (!this.ELF) {
                try {
                    randomAccessFile.close();
                    return;
                } catch (IOException unused) {
                    return;
                }
            }
            randomAccessFile.seek(4L);
            byte b3 = randomAccessFile.readByte();
            byte b4 = randomAccessFile.readByte();
            this._64Bit = b3 == 2;
            this.bigEndian = b4 == 2;
            randomAccessFile.seek(0L);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this._64Bit ? 64 : 52);
            randomAccessFile.getChannel().read(byteBufferAllocate, 0L);
            byteBufferAllocate.order(this.bigEndian ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
            boolean z3 = byteBufferAllocate.get(18) == 40;
            this.arm = z3;
            if (z3) {
                int i3 = byteBufferAllocate.getInt(this._64Bit ? 48 : 36);
                this.armHardFloatFlag = (i3 & EF_ARM_ABI_FLOAT_HARD) == EF_ARM_ABI_FLOAT_HARD;
                if ((i3 & EF_ARM_ABI_FLOAT_SOFT) != EF_ARM_ABI_FLOAT_SOFT) {
                    z2 = false;
                }
                this.armSoftFloatFlag = z2;
                parseEabiAapcsVfp(byteBufferAllocate, randomAccessFile);
            }
            try {
                randomAccessFile.close();
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (IOException unused3) {
            }
            throw th;
        }
    }

    public String getFilename() {
        return this.filename;
    }

    public boolean is64Bit() {
        return this._64Bit;
    }

    public boolean isArm() {
        return this.arm;
    }

    public boolean isArmEabiAapcsVfp() {
        return this.armEabiAapcsVfp;
    }

    public boolean isArmHardFloat() {
        return isArmEabiAapcsVfp() || isArmHardFloatFlag();
    }

    public boolean isArmHardFloatFlag() {
        return this.armHardFloatFlag;
    }

    public boolean isArmSoftFloatFlag() {
        return this.armSoftFloatFlag;
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public boolean isELF() {
        return this.ELF;
    }
}
