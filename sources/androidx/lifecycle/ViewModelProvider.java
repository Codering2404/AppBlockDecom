package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.ViewModelProviderImpl;
import androidx.lifecycle.viewmodel.internal.DefaultViewModelProviderFactory;
import androidx.lifecycle.viewmodel.internal.JvmViewModelProviders;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class ViewModelProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f40124b = new Companion(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CreationExtras.Key f40125c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewModelProviderImpl f40126a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ViewModelProvider c(Companion companion, ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                factory = DefaultViewModelProviderFactory.f40247b;
            }
            if ((i3 & 4) != 0) {
                creationExtras = CreationExtras.Empty.f40230c;
            }
            return companion.a(viewModelStore, factory, creationExtras);
        }

        public static /* synthetic */ ViewModelProvider d(Companion companion, ViewModelStoreOwner viewModelStoreOwner, Factory factory, CreationExtras creationExtras, int i3, Object obj) {
            if ((i3 & 2) != 0) {
                factory = androidx.lifecycle.viewmodel.internal.ViewModelProviders.f40253a.d(viewModelStoreOwner);
            }
            if ((i3 & 4) != 0) {
                creationExtras = androidx.lifecycle.viewmodel.internal.ViewModelProviders.f40253a.c(viewModelStoreOwner);
            }
            return companion.b(viewModelStoreOwner, factory, creationExtras);
        }

        public final ViewModelProvider a(ViewModelStore store, Factory factory, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(store, "store");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return new ViewModelProvider(store, factory, extras);
        }

        public final ViewModelProvider b(ViewModelStoreOwner owner, Factory factory, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(factory, "factory");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return new ViewModelProvider(owner.getViewModelStore(), factory, extras);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public interface Factory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Companion f40131a = Companion.f40132a;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            static final /* synthetic */ Companion f40132a = new Companion();

            private Companion() {
            }
        }

        default ViewModel create(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return androidx.lifecycle.viewmodel.internal.ViewModelProviders.f40253a.f();
        }

        default ViewModel create(Class modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return create(modelClass);
        }

        default ViewModel create(KClass modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return create(JvmClassMappingKt.a(modelClass), extras);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion(null);
        public static final CreationExtras.Key<String> VIEW_MODEL_KEY = ViewModelProvider.f40125c;
        private static NewInstanceFactory _instance;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NewInstanceFactory a() {
                if (NewInstanceFactory._instance == null) {
                    NewInstanceFactory._instance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory._instance;
                Intrinsics.checkNotNull(newInstanceFactory);
                return newInstanceFactory;
            }

            private Companion() {
            }
        }

        public static final NewInstanceFactory getInstance() {
            return Companion.a();
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            return JvmViewModelProviders.f40248a.a(modelClass);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(Class<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return (T) create(modelClass);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public <T extends ViewModel> T create(KClass<T> modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            return (T) create(JvmClassMappingKt.a(modelClass), extras);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class OnRequeryFactory {
        public void a(ViewModel viewModel) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        }
    }

    static {
        CreationExtras.Companion companion = CreationExtras.f40228b;
        f40125c = new CreationExtras.Key<String>() { // from class: androidx.lifecycle.ViewModelProvider$special$$inlined$Key$1
        };
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore store, Factory factory) {
        this(store, factory, null, 4, null);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    public ViewModel a(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return d(JvmClassMappingKt.c(modelClass));
    }

    public ViewModel b(String key, Class modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return this.f40126a.d(JvmClassMappingKt.c(modelClass), key);
    }

    public final ViewModel c(String key, KClass modelClass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return this.f40126a.d(modelClass, key);
    }

    public final ViewModel d(KClass modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        return ViewModelProviderImpl.e(this.f40126a, modelClass, null, 2, null);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static class AndroidViewModelFactory extends NewInstanceFactory {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Companion f40127c = new Companion(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static AndroidViewModelFactory f40128d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final CreationExtras.Key f40129e;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Application f40130b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final AndroidViewModelFactory a(Application application) {
                Intrinsics.checkNotNullParameter(application, "application");
                if (AndroidViewModelFactory.f40128d == null) {
                    AndroidViewModelFactory.f40128d = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.f40128d;
                Intrinsics.checkNotNull(androidViewModelFactory);
                return androidViewModelFactory;
            }

            private Companion() {
            }
        }

        static {
            CreationExtras.Companion companion = CreationExtras.f40228b;
            f40129e = new CreationExtras.Key<Application>() { // from class: androidx.lifecycle.ViewModelProvider$AndroidViewModelFactory$special$$inlined$Key$1
            };
        }

        private AndroidViewModelFactory(Application application, int i3) {
            this.f40130b = application;
        }

        private final ViewModel c(Class cls, Application application) {
            if (!AndroidViewModel.class.isAssignableFrom(cls)) {
                return super.create(cls);
            }
            try {
                ViewModel viewModel = (ViewModel) cls.getConstructor(Application.class).newInstance(application);
                Intrinsics.checkNotNull(viewModel);
                return viewModel;
            } catch (IllegalAccessException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            } catch (InstantiationException e4) {
                throw new RuntimeException("Cannot create an instance of " + cls, e4);
            } catch (NoSuchMethodException e5) {
                throw new RuntimeException("Cannot create an instance of " + cls, e5);
            } catch (InvocationTargetException e6) {
                throw new RuntimeException("Cannot create an instance of " + cls, e6);
            }
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(Class modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (this.f40130b != null) {
                return create(modelClass);
            }
            Application application = (Application) extras.a(f40129e);
            if (application != null) {
                return c(modelClass, application);
            }
            if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.create(modelClass);
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application) {
            this(application, 0);
            Intrinsics.checkNotNullParameter(application, "application");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Application application = this.f40130b;
            if (application != null) {
                return c(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }
    }

    private ViewModelProvider(ViewModelProviderImpl viewModelProviderImpl) {
        this.f40126a = viewModelProviderImpl;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory, (i3 & 4) != 0 ? CreationExtras.Empty.f40230c : creationExtras);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore store, Factory factory, CreationExtras defaultCreationExtras) {
        this(new ViewModelProviderImpl(store, factory, defaultCreationExtras));
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewModelProvider(ViewModelStoreOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        ViewModelStore viewModelStore = owner.getViewModelStore();
        androidx.lifecycle.viewmodel.internal.ViewModelProviders viewModelProviders = androidx.lifecycle.viewmodel.internal.ViewModelProviders.f40253a;
        this(viewModelStore, viewModelProviders.d(owner), viewModelProviders.c(owner));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner owner, Factory factory) {
        this(owner.getViewModelStore(), factory, androidx.lifecycle.viewmodel.internal.ViewModelProviders.f40253a.c(owner));
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }
}
