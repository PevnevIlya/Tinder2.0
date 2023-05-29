// Generated by view binder compiler. Do not edit!
package com.example.tinder20.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.tinder20.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentRegistrationFragmnetBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button confirm;

  @NonNull
  public final EditText email;

  @NonNull
  public final RadioButton femaleRadioButton;

  @NonNull
  public final RadioGroup genderRadioGroup;

  @NonNull
  public final RadioButton maleRadioButton;

  @NonNull
  public final EditText password;

  @NonNull
  public final TextView textOnPassword;

  @NonNull
  public final ToggleButton toggleButtonPassword;

  private FragmentRegistrationFragmnetBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button confirm, @NonNull EditText email, @NonNull RadioButton femaleRadioButton,
      @NonNull RadioGroup genderRadioGroup, @NonNull RadioButton maleRadioButton,
      @NonNull EditText password, @NonNull TextView textOnPassword,
      @NonNull ToggleButton toggleButtonPassword) {
    this.rootView = rootView;
    this.confirm = confirm;
    this.email = email;
    this.femaleRadioButton = femaleRadioButton;
    this.genderRadioGroup = genderRadioGroup;
    this.maleRadioButton = maleRadioButton;
    this.password = password;
    this.textOnPassword = textOnPassword;
    this.toggleButtonPassword = toggleButtonPassword;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentRegistrationFragmnetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentRegistrationFragmnetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_registration_fragmnet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentRegistrationFragmnetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.confirm;
      Button confirm = ViewBindings.findChildViewById(rootView, id);
      if (confirm == null) {
        break missingId;
      }

      id = R.id.email;
      EditText email = ViewBindings.findChildViewById(rootView, id);
      if (email == null) {
        break missingId;
      }

      id = R.id.femaleRadioButton;
      RadioButton femaleRadioButton = ViewBindings.findChildViewById(rootView, id);
      if (femaleRadioButton == null) {
        break missingId;
      }

      id = R.id.genderRadioGroup;
      RadioGroup genderRadioGroup = ViewBindings.findChildViewById(rootView, id);
      if (genderRadioGroup == null) {
        break missingId;
      }

      id = R.id.maleRadioButton;
      RadioButton maleRadioButton = ViewBindings.findChildViewById(rootView, id);
      if (maleRadioButton == null) {
        break missingId;
      }

      id = R.id.password;
      EditText password = ViewBindings.findChildViewById(rootView, id);
      if (password == null) {
        break missingId;
      }

      id = R.id.textOnPassword;
      TextView textOnPassword = ViewBindings.findChildViewById(rootView, id);
      if (textOnPassword == null) {
        break missingId;
      }

      id = R.id.toggleButton_password;
      ToggleButton toggleButtonPassword = ViewBindings.findChildViewById(rootView, id);
      if (toggleButtonPassword == null) {
        break missingId;
      }

      return new FragmentRegistrationFragmnetBinding((ConstraintLayout) rootView, confirm, email,
          femaleRadioButton, genderRadioGroup, maleRadioButton, password, textOnPassword,
          toggleButtonPassword);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
