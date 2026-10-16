package com.google.firebase.sessions;

import androidx.media3.common.JBEE.bfIdKSjLOVjG;
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
public final class EventType implements NumberedEnum {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final EventType f89956b = new EventType(bfIdKSjLOVjG.SVNNpWDiNOqkwgA, 0, 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final EventType f89957c = new EventType("SESSION_START", 1, 1);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final /* synthetic */ EventType[] f89958d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final /* synthetic */ EnumEntries f89959f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f89960a;

    private EventType(String str, int i3, int i4) {
        this.f89960a = i4;
    }

    private static final /* synthetic */ EventType[] a() {
        return new EventType[]{f89956b, f89957c};
    }

    public static EventType valueOf(String str) {
        return (EventType) Enum.valueOf(EventType.class, str);
    }

    public static EventType[] values() {
        return (EventType[]) f89958d.clone();
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    public int J() {
        return this.f89960a;
    }

    static {
        EventType[] eventTypeArrA = a();
        f89958d = eventTypeArrA;
        f89959f = EnumEntriesKt.a(eventTypeArrA);
    }
}
