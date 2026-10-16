package com.revenuecat.purchases.utils;

import com.facebook.internal.AnalyticsEvents;
import com.revenuecat.purchases.DebugEvent;
import com.revenuecat.purchases.DebugEventName;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.FileHelper;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.utils.Event;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

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
public class EventsFileHelper<T extends Event> {
    public static final Companion Companion = new Companion(null);
    public static final int MAX_EVENT_PROPERTY_SIZE = 80;
    private Function1<? super DebugEvent, Unit> debugEventCallback;
    private final Function1<String, T> eventDeserializer;
    private final Function1<T, String> eventSerializer;
    private final FileHelper fileHelper;
    private final String filePath;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public EventsFileHelper(FileHelper fileHelper, String filePath, Function1<? super T, String> function1, Function1<? super String, ? extends T> function12) {
        Intrinsics.checkNotNullParameter(fileHelper, "fileHelper");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.fileHelper = fileHelper;
        this.filePath = filePath;
        this.eventSerializer = function1;
        this.eventDeserializer = function12;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final T mapToEvent(String str) {
        Function1<String, T> function1 = this.eventDeserializer;
        if (function1 == null) {
            Function1<? super DebugEvent, Unit> function12 = this.debugEventCallback;
            if (function12 != null) {
                function12.invoke(new DebugEvent(DebugEventName.DESERIALIZATION_ERROR, MapsKt.emptyMap()));
            }
            return null;
        }
        try {
            return (T) function1.invoke(str);
        } catch (SerializationException e3) {
            Function1<? super DebugEvent, Unit> function13 = this.debugEventCallback;
            if (function13 != null) {
                DebugEventName debugEventName = DebugEventName.DESERIALIZATION_ERROR;
                Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                mapCreateMapBuilder.put("exceptionType", "SerializationException");
                String message = e3.getMessage();
                if (message != null) {
                    mapCreateMapBuilder.put("message", StringsKt.B1(message, 80));
                }
                Unit unit = Unit.f139807a;
                function13.invoke(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing event from file: " + str, e3);
            return null;
        } catch (IllegalArgumentException e4) {
            Function1<? super DebugEvent, Unit> function14 = this.debugEventCallback;
            if (function14 != null) {
                DebugEventName debugEventName2 = DebugEventName.DESERIALIZATION_ERROR;
                Map mapCreateMapBuilder2 = MapsKt.createMapBuilder();
                mapCreateMapBuilder2.put("exceptionType", "IllegalArgumentException");
                String message2 = e4.getMessage();
                if (message2 != null) {
                    mapCreateMapBuilder2.put("message", StringsKt.B1(message2, 80));
                }
                Unit unit2 = Unit.f139807a;
                function14.invoke(new DebugEvent(debugEventName2, MapsKt.build(mapCreateMapBuilder2)));
            }
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Error parsing event from file: " + str, e4);
            return null;
        }
    }

    public final synchronized void appendEvent(T event) {
        String string;
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            try {
                FileHelper fileHelper = this.fileHelper;
                String str = this.filePath;
                StringBuilder sb = new StringBuilder();
                Function1<T, String> function1 = this.eventSerializer;
                if (function1 == null || (string = (String) function1.invoke(event)) == null) {
                    string = event.toString();
                }
                sb.append(string);
                sb.append('\n');
                fileHelper.appendToFile(str, sb.toString());
            } catch (Exception e3) {
                Function1<? super DebugEvent, Unit> function12 = this.debugEventCallback;
                if (function12 != null) {
                    DebugEventName debugEventName = DebugEventName.APPEND_EVENT_EXCEPTION;
                    Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                    String strM = Reflection.b(e3.getClass()).m();
                    if (strM == null) {
                        strM = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }
                    mapCreateMapBuilder.put("exceptionType", strM);
                    String message = e3.getMessage();
                    if (message != null) {
                        mapCreateMapBuilder.put("message", StringsKt.B1(message, 80));
                    }
                    Unit unit = Unit.f139807a;
                    function12.invoke(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
                }
                throw e3;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void clear(int i3) {
        this.fileHelper.removeFirstLinesFromFile(this.filePath, i3, new Function1<Throwable, Unit>(this) { // from class: com.revenuecat.purchases.utils.EventsFileHelper.clear.1
            final /* synthetic */ EventsFileHelper<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Throwable) obj);
                return Unit.f139807a;
            }

            public final void invoke(Throwable e3) {
                Intrinsics.checkNotNullParameter(e3, "e");
                Function1<DebugEvent, Unit> debugEventCallback = this.this$0.getDebugEventCallback();
                if (debugEventCallback != null) {
                    DebugEventName debugEventName = DebugEventName.REMOVE_LINES_EXCEPTION;
                    Map mapCreateMapBuilder = MapsKt.createMapBuilder();
                    String strM = Reflection.b(e3.getClass()).m();
                    if (strM == null) {
                        strM = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    }
                    mapCreateMapBuilder.put("exceptionType", strM);
                    String message = e3.getMessage();
                    if (message != null) {
                        mapCreateMapBuilder.put("message", StringsKt.B1(message, 80));
                    }
                    Unit unit = Unit.f139807a;
                    debugEventCallback.invoke(new DebugEvent(debugEventName, MapsKt.build(mapCreateMapBuilder)));
                }
            }
        });
    }

    public final synchronized void deleteFile() {
        if (!this.fileHelper.deleteFile(this.filePath)) {
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.v("[Purchases] - " + logLevel.name(), "Failed to delete events file in " + this.filePath + '.');
            }
        }
    }

    public final synchronized double fileSizeInKB() {
        return this.fileHelper.fileSizeInKB(this.filePath);
    }

    public final Function1<DebugEvent, Unit> getDebugEventCallback() {
        return this.debugEventCallback;
    }

    public final synchronized void readFile(final Function1<? super Sequence<? extends T>, Unit> block) {
        try {
            Intrinsics.checkNotNullParameter(block, "block");
            if (this.eventDeserializer == null || this.fileHelper.fileIsEmpty(this.filePath)) {
                block.invoke(SequencesKt.g());
            } else {
                this.fileHelper.readFilePerLines(this.filePath, new Function1<Sequence<? extends String>, Unit>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFile.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Sequence<String>) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(Sequence<String> sequence) {
                        Intrinsics.checkNotNullParameter(sequence, "sequence");
                        Function1<Sequence<? extends T>, Unit> function1 = block;
                        final EventsFileHelper<T> eventsFileHelper = this;
                        function1.invoke(SequencesKt.M(sequence, new Function1<String, T>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFile.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final T invoke(String line) {
                                Intrinsics.checkNotNullParameter(line, "line");
                                return (T) eventsFileHelper.mapToEvent(line);
                            }
                        }));
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void readFileAsJson(final Function1<? super Sequence<? extends JSONObject>, Unit> block) {
        try {
            Intrinsics.checkNotNullParameter(block, "block");
            if (this.fileHelper.fileIsEmpty(this.filePath)) {
                block.invoke(SequencesKt.g());
            } else {
                this.fileHelper.readFilePerLines(this.filePath, new Function1<Sequence<? extends String>, Unit>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFileAsJson.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Sequence<String>) obj);
                        return Unit.f139807a;
                    }

                    public final void invoke(Sequence<String> sequence) {
                        Intrinsics.checkNotNullParameter(sequence, "sequence");
                        block.invoke(SequencesKt.M(sequence, new Function1<String, JSONObject>() { // from class: com.revenuecat.purchases.utils.EventsFileHelper.readFileAsJson.1.1
                            @Override // kotlin.jvm.functions.Function1
                            public final JSONObject invoke(String it) {
                                Intrinsics.checkNotNullParameter(it, "it");
                                return new JSONObject(it);
                            }
                        }));
                    }
                });
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setDebugEventCallback(Function1<? super DebugEvent, Unit> function1) {
        this.debugEventCallback = function1;
    }

    public /* synthetic */ EventsFileHelper(FileHelper fileHelper, String str, Function1 function1, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(fileHelper, str, (i3 & 4) != 0 ? null : function1, (i3 & 8) != 0 ? null : function12);
    }
}
