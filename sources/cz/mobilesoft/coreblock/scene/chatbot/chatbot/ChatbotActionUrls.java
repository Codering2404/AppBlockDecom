package cz.mobilesoft.coreblock.scene.chatbot.chatbot;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.text.Regex;

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
public final class ChatbotActionUrls {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ChatbotActionUrls[] $VALUES;
    public static final ChatbotActionUrls CONTACT_SUPPORT = new ChatbotActionUrls("CONTACT_SUPPORT", 0, new Regex("^https://appblock\\.app/contact(?:/.*)?$"));
    private final Regex urlPattern;

    private static final /* synthetic */ ChatbotActionUrls[] $values() {
        return new ChatbotActionUrls[]{CONTACT_SUPPORT};
    }

    static {
        ChatbotActionUrls[] chatbotActionUrlsArr$values = $values();
        $VALUES = chatbotActionUrlsArr$values;
        $ENTRIES = EnumEntriesKt.a(chatbotActionUrlsArr$values);
    }

    private ChatbotActionUrls(String str, int i3, Regex regex) {
        this.urlPattern = regex;
    }

    public static EnumEntries<ChatbotActionUrls> getEntries() {
        return $ENTRIES;
    }

    public static ChatbotActionUrls valueOf(String str) {
        return (ChatbotActionUrls) Enum.valueOf(ChatbotActionUrls.class, str);
    }

    public static ChatbotActionUrls[] values() {
        return (ChatbotActionUrls[]) $VALUES.clone();
    }

    public final Regex getUrlPattern() {
        return this.urlPattern;
    }
}
