package cz.mobilesoft.coreblock.enums;

import cz.mobilesoft.coreblock.R;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class BlockingTestAppIcon {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BlockingTestAppIcon[] $VALUES;
    private final String label;
    private final int resId;
    public static final BlockingTestAppIcon Threads = new BlockingTestAppIcon("Threads", 0, "Threads", R.drawable.lb);
    public static final BlockingTestAppIcon Chrome = new BlockingTestAppIcon("Chrome", 1, "Chrome", R.drawable.f95578y);
    public static final BlockingTestAppIcon Youtube = new BlockingTestAppIcon("Youtube", 2, "Youtube", R.drawable.Ab);
    public static final BlockingTestAppIcon Instagram = new BlockingTestAppIcon("Instagram", 3, "Instagram", R.drawable.k8);
    public static final BlockingTestAppIcon Facebook = new BlockingTestAppIcon("Facebook", 4, "Facebook", R.drawable.I);
    public static final BlockingTestAppIcon LinkedIn = new BlockingTestAppIcon("LinkedIn", 5, "LinkedIn", R.drawable.p8);
    public static final BlockingTestAppIcon Calendar = new BlockingTestAppIcon("Calendar", 6, "Calendar", R.drawable.f95566u);
    public static final BlockingTestAppIcon Slack = new BlockingTestAppIcon("Slack", 7, "Slack", R.drawable.Ra);
    public static final BlockingTestAppIcon X = new BlockingTestAppIcon("X", 8, "X", R.drawable.zb);
    public static final BlockingTestAppIcon Airbnb = new BlockingTestAppIcon("Airbnb", 9, "Airbnb", R.drawable.f95489a);
    public static final BlockingTestAppIcon Clock = new BlockingTestAppIcon("Clock", 10, "Clock", R.drawable.f95581z);
    public static final BlockingTestAppIcon Contacts = new BlockingTestAppIcon("Contacts", 11, "Contacts", R.drawable.A);
    public static final BlockingTestAppIcon Chat = new BlockingTestAppIcon("Chat", 12, "Chat", R.drawable.f95572w);
    public static final BlockingTestAppIcon Camera = new BlockingTestAppIcon("Camera", 13, "Camera", R.drawable.f95569v);
    public static final BlockingTestAppIcon Discord = new BlockingTestAppIcon("Discord", 14, "Discord", R.drawable.B);
    public static final BlockingTestAppIcon Doordash = new BlockingTestAppIcon("Doordash", 15, "Doordash", R.drawable.C);
    public static final BlockingTestAppIcon Drive = new BlockingTestAppIcon("Drive", 16, "Drive", R.drawable.D);
    public static final BlockingTestAppIcon Dropbox = new BlockingTestAppIcon("Dropbox", 17, "Dropbox", R.drawable.E);
    public static final BlockingTestAppIcon Files = new BlockingTestAppIcon("Files", 18, "Files", R.drawable.J);
    public static final BlockingTestAppIcon FindHub = new BlockingTestAppIcon("FindHub", 19, "Find Hub", R.drawable.K);

    private static final /* synthetic */ BlockingTestAppIcon[] $values() {
        return new BlockingTestAppIcon[]{Threads, Chrome, Youtube, Instagram, Facebook, LinkedIn, Calendar, Slack, X, Airbnb, Clock, Contacts, Chat, Camera, Discord, Doordash, Drive, Dropbox, Files, FindHub};
    }

    static {
        BlockingTestAppIcon[] blockingTestAppIconArr$values = $values();
        $VALUES = blockingTestAppIconArr$values;
        $ENTRIES = EnumEntriesKt.a(blockingTestAppIconArr$values);
    }

    private BlockingTestAppIcon(String str, int i3, String str2, int i4) {
        this.label = str2;
        this.resId = i4;
    }

    public static EnumEntries<BlockingTestAppIcon> getEntries() {
        return $ENTRIES;
    }

    public static BlockingTestAppIcon valueOf(String str) {
        return (BlockingTestAppIcon) Enum.valueOf(BlockingTestAppIcon.class, str);
    }

    public static BlockingTestAppIcon[] values() {
        return (BlockingTestAppIcon[]) $VALUES.clone();
    }

    public final String getLabel() {
        return this.label;
    }

    public final int getResId() {
        return this.resId;
    }
}
