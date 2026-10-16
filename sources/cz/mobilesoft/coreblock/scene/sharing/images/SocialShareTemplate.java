package cz.mobilesoft.coreblock.scene.sharing.images;

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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class SocialShareTemplate {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SocialShareTemplate[] $VALUES;
    public static final SocialShareTemplate ScreenTimePortrait;
    public static final SocialShareTemplate ScreenTimeSquare;
    public static final SocialShareTemplate ScreenTimeTransparent;
    public static final SocialShareTemplate UpsDownsPortrait;
    public static final SocialShareTemplate UpsDownsSquare;
    public static final SocialShareTemplate UpsDownsTransparent;
    public static final SocialShareTemplate WeeklyReportPortrait;
    private final Content content;
    private final Format format;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Content {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Content[] $VALUES;
        public static final Content ScreenTime = new Content("ScreenTime", 0);
        public static final Content UpsDowns = new Content("UpsDowns", 1);
        public static final Content WeeklyReport = new Content("WeeklyReport", 2);

        private static final /* synthetic */ Content[] $values() {
            return new Content[]{ScreenTime, UpsDowns, WeeklyReport};
        }

        static {
            Content[] contentArr$values = $values();
            $VALUES = contentArr$values;
            $ENTRIES = EnumEntriesKt.a(contentArr$values);
        }

        private Content(String str, int i3) {
        }

        public static EnumEntries<Content> getEntries() {
            return $ENTRIES;
        }

        public static Content valueOf(String str) {
            return (Content) Enum.valueOf(Content.class, str);
        }

        public static Content[] values() {
            return (Content[]) $VALUES.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Format {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Format[] $VALUES;
        private final int heightPx;
        private final float previewAspectRatio;
        private final int widthPx;
        public static final Format Square = new Format("Square", 0, 1080, 1080, 1.0f);
        public static final Format Portrait = new Format("Portrait", 1, 1080, 1920, 0.5625f);
        public static final Format Transparent = new Format("Transparent", 2, 1080, 1920, 0.5625f);

        private static final /* synthetic */ Format[] $values() {
            return new Format[]{Square, Portrait, Transparent};
        }

        static {
            Format[] formatArr$values = $values();
            $VALUES = formatArr$values;
            $ENTRIES = EnumEntriesKt.a(formatArr$values);
        }

        private Format(String str, int i3, int i4, int i5, float f3) {
            this.widthPx = i4;
            this.heightPx = i5;
            this.previewAspectRatio = f3;
        }

        public static EnumEntries<Format> getEntries() {
            return $ENTRIES;
        }

        public static Format valueOf(String str) {
            return (Format) Enum.valueOf(Format.class, str);
        }

        public static Format[] values() {
            return (Format[]) $VALUES.clone();
        }

        public final int getHeightPx() {
            return this.heightPx;
        }

        public final float getPreviewAspectRatio() {
            return this.previewAspectRatio;
        }

        public final int getWidthPx() {
            return this.widthPx;
        }
    }

    private static final /* synthetic */ SocialShareTemplate[] $values() {
        return new SocialShareTemplate[]{ScreenTimeSquare, ScreenTimePortrait, UpsDownsSquare, UpsDownsPortrait, ScreenTimeTransparent, UpsDownsTransparent, WeeklyReportPortrait};
    }

    static {
        Content content = Content.ScreenTime;
        Format format = Format.Square;
        ScreenTimeSquare = new SocialShareTemplate("ScreenTimeSquare", 0, content, format);
        Format format2 = Format.Portrait;
        ScreenTimePortrait = new SocialShareTemplate("ScreenTimePortrait", 1, content, format2);
        Content content2 = Content.UpsDowns;
        UpsDownsSquare = new SocialShareTemplate("UpsDownsSquare", 2, content2, format);
        UpsDownsPortrait = new SocialShareTemplate("UpsDownsPortrait", 3, content2, format2);
        Format format3 = Format.Transparent;
        ScreenTimeTransparent = new SocialShareTemplate("ScreenTimeTransparent", 4, content, format3);
        UpsDownsTransparent = new SocialShareTemplate("UpsDownsTransparent", 5, content2, format3);
        WeeklyReportPortrait = new SocialShareTemplate("WeeklyReportPortrait", 6, Content.WeeklyReport, format2);
        SocialShareTemplate[] socialShareTemplateArr$values = $values();
        $VALUES = socialShareTemplateArr$values;
        $ENTRIES = EnumEntriesKt.a(socialShareTemplateArr$values);
    }

    private SocialShareTemplate(String str, int i3, Content content, Format format) {
        this.content = content;
        this.format = format;
    }

    public static EnumEntries<SocialShareTemplate> getEntries() {
        return $ENTRIES;
    }

    public static SocialShareTemplate valueOf(String str) {
        return (SocialShareTemplate) Enum.valueOf(SocialShareTemplate.class, str);
    }

    public static SocialShareTemplate[] values() {
        return (SocialShareTemplate[]) $VALUES.clone();
    }

    public final Content getContent() {
        return this.content;
    }

    public final Format getFormat() {
        return this.format;
    }
}
