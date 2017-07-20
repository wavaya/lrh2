# lrh2
爱家阅图书管理系统采用Google提出最新框架进行改版版本，Room 数据库，LiveData 、ViewModel 、Lifecycle 、LifecycleOwner 、Dragger2等


随着《Google 官方Android开发新架构指南》的发布，一大波新的框架随之出现。
最近，官方推出了一份关于应用架构的最佳实践指南。这里就给大家简要介绍一下：
首先，Android 开发者肯定都知道 Android 中有四大组件，这些组件都有各自的生命周期并且在一定程度上是不受你控制的。在任何时候，Android 操作系统都可能根据用户的行为或资源紧张等原因回收掉这些组件。
这也就引出了第一条准则：「不要在应用程序组件中保存任何应用数据或状态，并且组件间也不应该相互依赖」。
最常见的错误就是在 Activity 或 Fragment 中写了与 UI 和交互无关的代码。尽可能减少对它们的依赖，这能避免大量生命周期导致的问题，以提供更好的用户体验。
第二条准则：「通过 model 驱动应用 UI，并尽可能的持久化」。
这样做主要有两个原因：
如果系统回收了你的应用资源或其他什么意外情况，不会导致用户丢失数据。
Model 就应该是负责处理应用程序数据的组件。独立于视图和应用程序组件，保持了视图代码的简单，也让你的应用逻辑更容易管理。并且，将应用数据置于 model 类中，也更有利于测试。
官方推荐架构
架构组件的基本框架包括：
· Room - 一个SQLite对象映射器。非常类似于其他库，如ORMlite或greenDAO。它使用SQL，同时仍然允许对查询的编译时保证。
· LiveData - 一个Lifecycle可观察的核心组件。
· ViewModel - 应用程序的其他部分与Activities/Fragmets通讯点。它们与UI代码无关。
· Lifecycle - 架构自检的核心部分，它包含组件(例如一个Activity)的生命状态信息。
· LifecycleOwner - 具有Lifecycle(Activity，Fragment，Process，自定义组件)的组件的核心接口。
· LifecycleObserver - 指定出发某些生命周期方法是应该发生的情况。创建LifecycleObserver允许组件自包含。

于是本人抽出时间将爱家阅图书管理系统按新框架进行改版本，采用以上框架。
