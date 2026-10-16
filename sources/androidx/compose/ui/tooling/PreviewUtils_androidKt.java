package androidx.compose.ui.tooling;

import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class PreviewUtils_androidKt {
    public static final Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e3) {
            PreviewLogger.f29762a.a("Unable to find PreviewProvider '" + str + '\'', e3);
            return null;
        }
    }

    public static final List b(Group group, Function1 function1) {
        return d(group, function1, false, 4, null);
    }

    public static final List c(Group group, Function1 function1, boolean z2) {
        ArrayList arrayList = new ArrayList();
        List listMutableListOf = CollectionsKt.mutableListOf(group);
        while (!listMutableListOf.isEmpty()) {
            Group group2 = (Group) CollectionsKt.removeLast(listMutableListOf);
            if (((Boolean) function1.invoke(group2)).booleanValue()) {
                if (z2) {
                    return CollectionsKt.listOf(group2);
                }
                arrayList.add(group2);
            }
            listMutableListOf.addAll(group2.b());
        }
        return arrayList;
    }

    public static /* synthetic */ List d(Group group, Function1 function1, boolean z2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return c(group, function1, z2);
    }

    public static final Group e(Group group, Function1 function1) {
        return (Group) CollectionsKt.firstOrNull(c(group, function1, true));
    }

    public static final Object[] f(Class cls, int i3) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        if (cls == null) {
            return new Object[0];
        }
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            int i4 = 0;
            boolean z2 = false;
            Constructor<?> constructor = null;
            while (true) {
                if (i4 < length) {
                    Constructor<?> constructor2 = constructors[i4];
                    if (constructor2.getParameterTypes().length == 0) {
                        if (z2) {
                            break;
                        }
                        z2 = true;
                        constructor = constructor2;
                    }
                    i4++;
                } else if (!z2) {
                }
            }
            constructor = null;
            if (constructor == null) {
                throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
            }
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
            PreviewParameterProvider previewParameterProvider = (PreviewParameterProvider) objNewInstance;
            if (i3 < 0) {
                return g(previewParameterProvider.getValues(), previewParameterProvider.getCount());
            }
            List listListOf = CollectionsKt.listOf(SequencesKt.x(previewParameterProvider.getValues(), i3));
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                arrayList.add(h(it.next()));
            }
            return arrayList.toArray(new Object[0]);
        } catch (KotlinReflectionNotSupportedError unused) {
            throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
        }
    }

    public static final Object[] g(Sequence sequence, int i3) {
        Iterator it = sequence.iterator();
        Object[] objArr = new Object[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = it.next();
        }
        return objArr;
    }

    public static final Object h(Object obj) throws NoSuchFieldException {
        if (obj != null) {
            for (Annotation annotation : obj.getClass().getAnnotations()) {
                if (annotation instanceof JvmInline) {
                    for (Field field : obj.getClass().getDeclaredFields()) {
                        if (field.getType().isPrimitive()) {
                            Field declaredField = obj.getClass().getDeclaredField(field.getName());
                            declaredField.setAccessible(true);
                            return declaredField.get(obj);
                        }
                    }
                    throw new NoSuchElementException("Array contains no element matching the predicate.");
                }
            }
        }
        return obj;
    }
}
