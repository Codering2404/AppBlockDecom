package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.preference.Preference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class SeekBarPreference extends Preference {
    int Q;
    int R;
    private int S;
    private int T;
    boolean U;
    SeekBar V;
    private TextView W;
    boolean X;
    private boolean Y;
    boolean Z;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private final SeekBar.OnSeekBarChangeListener f51059a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private final View.OnKeyListener f51060b0;

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3, int i4) {
        super(context, attributeSet, i3, i4);
        this.f51059a0 = new SeekBar.OnSeekBarChangeListener() { // from class: androidx.preference.SeekBarPreference.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i5, boolean z2) {
                if (z2) {
                    SeekBarPreference seekBarPreference = SeekBarPreference.this;
                    if (seekBarPreference.Z || !seekBarPreference.U) {
                        seekBarPreference.H0(seekBar);
                        return;
                    }
                }
                SeekBarPreference seekBarPreference2 = SeekBarPreference.this;
                seekBarPreference2.I0(i5 + seekBarPreference2.R);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.U = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                SeekBarPreference.this.U = false;
                int progress = seekBar.getProgress();
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if (progress + seekBarPreference.R != seekBarPreference.Q) {
                    seekBarPreference.H0(seekBar);
                }
            }
        };
        this.f51060b0 = new View.OnKeyListener() { // from class: androidx.preference.SeekBarPreference.2
            @Override // android.view.View.OnKeyListener
            public boolean onKey(View view, int i5, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 0) {
                    return false;
                }
                SeekBarPreference seekBarPreference = SeekBarPreference.this;
                if ((!seekBarPreference.X && (i5 == 21 || i5 == 22)) || i5 == 23 || i5 == 66) {
                    return false;
                }
                SeekBar seekBar = seekBarPreference.V;
                if (seekBar != null) {
                    return seekBar.onKeyDown(i5, keyEvent);
                }
                Log.e("SeekBarPreference", "SeekBar view is null and hence cannot be adjusted.");
                return false;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.L0, i3, i4);
        this.R = typedArrayObtainStyledAttributes.getInt(R.styleable.O0, 0);
        E0(typedArrayObtainStyledAttributes.getInt(R.styleable.M0, 100));
        F0(typedArrayObtainStyledAttributes.getInt(R.styleable.P0, 0));
        this.X = typedArrayObtainStyledAttributes.getBoolean(R.styleable.N0, true);
        this.Y = typedArrayObtainStyledAttributes.getBoolean(R.styleable.Q0, false);
        this.Z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.R0, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void G0(int i3, boolean z2) {
        int i4 = this.R;
        if (i3 < i4) {
            i3 = i4;
        }
        int i5 = this.S;
        if (i3 > i5) {
            i3 = i5;
        }
        if (i3 != this.Q) {
            this.Q = i3;
            I0(i3);
            d0(i3);
            if (z2) {
                H();
            }
        }
    }

    public final void E0(int i3) {
        int i4 = this.R;
        if (i3 < i4) {
            i3 = i4;
        }
        if (i3 != this.S) {
            this.S = i3;
            H();
        }
    }

    public final void F0(int i3) {
        if (i3 != this.T) {
            this.T = Math.min(this.S - this.R, Math.abs(i3));
            H();
        }
    }

    void H0(SeekBar seekBar) {
        int progress = this.R + seekBar.getProgress();
        if (progress != this.Q) {
            if (b(Integer.valueOf(progress))) {
                G0(progress, false);
            } else {
                seekBar.setProgress(this.Q - this.R);
                I0(this.Q);
            }
        }
    }

    void I0(int i3) {
        TextView textView = this.W;
        if (textView != null) {
            textView.setText(String.valueOf(i3));
        }
    }

    @Override // androidx.preference.Preference
    public void Q(PreferenceViewHolder preferenceViewHolder) {
        super.Q(preferenceViewHolder);
        preferenceViewHolder.itemView.setOnKeyListener(this.f51060b0);
        this.V = (SeekBar) preferenceViewHolder.b(R.id.f50977f);
        TextView textView = (TextView) preferenceViewHolder.b(R.id.f50978g);
        this.W = textView;
        if (this.Y) {
            textView.setVisibility(0);
        } else {
            textView.setVisibility(8);
            this.W = null;
        }
        SeekBar seekBar = this.V;
        if (seekBar == null) {
            Log.e("SeekBarPreference", "SeekBar view is null in onBindViewHolder.");
            return;
        }
        seekBar.setOnSeekBarChangeListener(this.f51059a0);
        this.V.setMax(this.S - this.R);
        int i3 = this.T;
        if (i3 != 0) {
            this.V.setKeyProgressIncrement(i3);
        } else {
            this.T = this.V.getKeyProgressIncrement();
        }
        this.V.setProgress(this.Q - this.R);
        I0(this.Q);
        this.V.setEnabled(D());
    }

    @Override // androidx.preference.Preference
    protected Object U(TypedArray typedArray, int i3) {
        return Integer.valueOf(typedArray.getInt(i3, 0));
    }

    @Override // androidx.preference.Preference
    protected void Y(Parcelable parcelable) {
        if (parcelable == null || !parcelable.getClass().equals(SavedState.class)) {
            super.Y(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.Y(savedState.getSuperState());
        this.Q = savedState.f51063a;
        this.R = savedState.f51064b;
        this.S = savedState.f51065c;
        H();
    }

    @Override // androidx.preference.Preference
    protected Parcelable Z() {
        Parcelable parcelableZ = super.Z();
        if (E()) {
            return parcelableZ;
        }
        SavedState savedState = new SavedState(parcelableZ);
        savedState.f51063a = this.Q;
        savedState.f51064b = this.R;
        savedState.f51065c = this.S;
        return savedState;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SavedState extends Preference.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.preference.SeekBarPreference.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i3) {
                return new SavedState[i3];
            }
        };

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f51063a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f51064b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f51065c;

        SavedState(Parcel parcel) {
            super(parcel);
            this.f51063a = parcel.readInt();
            this.f51064b = parcel.readInt();
            this.f51065c = parcel.readInt();
        }

        @Override // android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeInt(this.f51063a);
            parcel.writeInt(this.f51064b);
            parcel.writeInt(this.f51065c);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0);
    }

    public SeekBarPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.f50966k);
    }
}
