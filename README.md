# Kind

Kind binds Kotlin properties to Android views and values.
 
 * Avoid using `lateinit` and `findViewById`
 * Bind directly to the values of views
 * No annotation processing, everything is done at runtime using 
 standard Kotlin features

```kotlin
class MyActivity : AppCompatActivity() {

    val textArea by bind<TextView>(R.id.text_view)
    var checkBoxValue by bind<CheckBox>(R.id.checkbox_view).value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_standard_widgets)

        textArea.setBackgroundColor(Color.BLUE)
        checkBoxValue = true // default check box to checked
    }
}
```
## Getting Started

Available through JCenter and Maven Central
```groovy
dependencies {
    compile 'com.crswty.kind:kind:0.1.1'
}
```

## Binding to Views

Binding to views is the simplest case, this style makes means you don't
have to declare the checkbox as `lateinit` and then assign to it in 
`onCreate` or `onCreateView` leaving you with a clean declarative style

```kotlin
class MyActivity: Activity() {
    val checkBox by bind<CheckBox>(R.id.yes_no_checkbox)
}
```

## Binding to Values

Sometime you don't even need to interact with the views in your layout,
it these cases, Kind makes it easy to to bind to the underlying values of
those views. in this example you simple bind to a `Boolean` that represents
 if the check box is checked or not.


```kotlin
class MyActivity: Activity() {
    var checkBoxValue by bind<CheckBox>(R.id.yes_no_checkbox).value
}
```

## Binding to Activities/Fragments/Views/Anything

Kind will work with properties declared on Activities, Fragments, and Views 
 out of the box but it will also work on any other class that implements
 the `ViewProvider` interface.