(this["webpackJsonpswapper-client"]=this["webpackJsonpswapper-client"]||[]).push([[0],{207:function(e,t,a){e.exports=a(521)},216:function(e,t,a){},218:function(e,t,a){},521:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),s=a(102),o=a.n(s),c=a(49),l=a(60),i=a(204),m=a(205),u=a(15),h=JSON.parse(localStorage.getItem("user")),d=h?{isLoggedIn:!0,user:h}:{isLoggedIn:!1,user:null},g={},v=Object(l.combineReducers)({auth:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:d,t=arguments.length>1?arguments[1]:void 0,a=t.type,n=t.payload;switch(a){case"REGISTER_SUCCESS":case"REGISTER_FAIL":return Object(u.a)(Object(u.a)({},e),{},{isLoggedIn:!1});case"LOGIN_SUCCESS":return Object(u.a)(Object(u.a)({},e),{},{isLoggedIn:!0,user:n.user});case"LOGIN_FAIL":case"LOGOUT":return Object(u.a)(Object(u.a)({},e),{},{isLoggedIn:!1,user:null});default:return e}},message:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:g,t=arguments.length>1?arguments[1]:void 0,a=t.type,n=t.payload;switch(a){case"SET_MESSAGE":return{message:n};case"CLEAR_MESSAGE":return{message:""};default:return e}}}),p=[m.a],b=Object(l.createStore)(v,Object(i.composeWithDevTools)(l.applyMiddleware.apply(void 0,p))),E=(a(216),a(17)),f=a(18),C=a(19),O=a(23),N=a(22),y=a(16),S=a(46),j=(a(217),a(218),a(104)),k=a.n(j),w=a(38),L=a.n(w),I=a(105),P=a.n(I),A=a(61),T=a.n(A),U=new(function(){function e(){Object(E.a)(this,e)}return Object(f.a)(e,[{key:"login",value:function(e,t){return T.a.post("/api/auth/signin",{username:e,password:t}).then((function(e){return e.data.accessToken&&localStorage.setItem("user",JSON.stringify(e.data)),e.data}))}},{key:"logout",value:function(){localStorage.removeItem("user")}},{key:"register",value:function(e,t,a,n,r){return T.a.post("/api/auth/signup",{username:e,email:t,password:a,phoneNumber:n,contact:r})}}]),e}()),B=function(e){if(!e)return r.a.createElement("div",{className:"alert alert-danger",role:"alert"},"This field is required!")},M=function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(e){var n;return Object(E.a)(this,a),(n=t.call(this,e)).handleLogin=n.handleLogin.bind(Object(C.a)(n)),n.onChangeUsername=n.onChangeUsername.bind(Object(C.a)(n)),n.onChangePassword=n.onChangePassword.bind(Object(C.a)(n)),n.state={username:"",password:"",loading:!1},n}return Object(f.a)(a,[{key:"onChangeUsername",value:function(e){this.setState({username:e.target.value})}},{key:"onChangePassword",value:function(e){this.setState({password:e.target.value})}},{key:"handleLogin",value:function(e){var t=this;e.preventDefault(),this.setState({loading:!0}),this.form.validateAll();var a,n,r=this.props,s=r.dispatch,o=r.history;0===this.checkBtn.context._errors.length?s((a=this.state.username,n=this.state.password,function(e){return U.login(a,n).then((function(t){return e({type:"LOGIN_SUCCESS",payload:{user:t}}),Promise.resolve()}),(function(t){var a=t.response&&t.response.data&&t.response.data.message||t.message||t.toString();return e({type:"LOGIN_FAIL"}),e({type:"SET_MESSAGE",payload:a}),Promise.reject()}))})).then((function(){o.push("/profile"),window.location.reload()})).catch((function(){t.setState({loading:!1})})):this.setState({loading:!1})}},{key:"render",value:function(){var e=this,t=this.props,a=t.isLoggedIn,n=t.message;return a?r.a.createElement(y.a,{to:"/profile"}):r.a.createElement("div",{className:"col-md-12"},r.a.createElement("div",{className:"card card-container"},r.a.createElement("img",{src:"//ssl.gstatic.com/accounts/ui/avatar_2x.png",alt:"profile-img",className:"profile-img-card"}),r.a.createElement(k.a,{onSubmit:this.handleLogin,ref:function(t){e.form=t}},r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"username"},"Username"),r.a.createElement(L.a,{type:"text",className:"form-control",name:"username",value:this.state.username,onChange:this.onChangeUsername,validations:[B]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"password"},"Password"),r.a.createElement(L.a,{type:"password",className:"form-control",name:"password",value:this.state.password,onChange:this.onChangePassword,validations:[B]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("button",{className:"btn btn-primary btn-block",disabled:this.state.loading},this.state.loading&&r.a.createElement("span",{className:"spinner-border spinner-border-sm"}),r.a.createElement("span",null,"Login"))),n&&r.a.createElement("div",{className:"form-group"},r.a.createElement("div",{className:"alert alert-danger",role:"alert"},n)),r.a.createElement(P.a,{style:{display:"none"},ref:function(t){e.checkBtn=t}}))))}}]),a}(n.Component);var _=Object(c.b)((function(e){return{isLoggedIn:e.auth.isLoggedIn,message:e.message.message}}))(M),R=a(206),G=function(e){if(!e)return r.a.createElement("div",{className:"alert alert-danger",role:"alert"},"This field is required!")},F=function(e){if(!Object(R.isEmail)(e))return r.a.createElement("div",{className:"alert alert-danger",role:"alert"},"This is not a valid email.")},x=function(e){if(e.length<3||e.length>20)return r.a.createElement("div",{className:"alert alert-danger",role:"alert"},"The username must be between 3 and 20 characters.")},D=function(e){if(e.length<6||e.length>40)return r.a.createElement("div",{className:"alert alert-danger",role:"alert"},"The password must be between 6 and 40 characters.")},J=function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(e){var n;return Object(E.a)(this,a),(n=t.call(this,e)).handleRegister=n.handleRegister.bind(Object(C.a)(n)),n.onChangeUsername=n.onChangeUsername.bind(Object(C.a)(n)),n.onChangeEmail=n.onChangeEmail.bind(Object(C.a)(n)),n.onChangePassword=n.onChangePassword.bind(Object(C.a)(n)),n.onChangePhoneNumber=n.onChangePhoneNumber.bind(Object(C.a)(n)),n.onChangeStreet=n.onChangeStreet.bind(Object(C.a)(n)),n.onChangeCity=n.onChangeCity.bind(Object(C.a)(n)),n.onChangeState=n.onChangeState.bind(Object(C.a)(n)),n.onChangePostalCode=n.onChangePostalCode.bind(Object(C.a)(n)),n.onChangeCountry=n.onChangeCountry.bind(Object(C.a)(n)),n.state={username:"",email:"",password:"",phoneNumber:"",contact:{street:"",city:"",state:"",postalCode:"",country:""},successful:!1},n}return Object(f.a)(a,[{key:"onChangeUsername",value:function(e){this.setState({username:e.target.value})}},{key:"onChangeEmail",value:function(e){this.setState({email:e.target.value})}},{key:"onChangePassword",value:function(e){this.setState({password:e.target.value})}},{key:"onChangePhoneNumber",value:function(e){this.setState({phoneNumber:e.target.value})}},{key:"onChangeStreet",value:function(e){this.setState({contact:Object(u.a)(Object(u.a)({},this.state.contact),{},{street:e.target.value})})}},{key:"onChangeCity",value:function(e){this.setState({contact:Object(u.a)(Object(u.a)({},this.state.contact),{},{city:e.target.value})})}},{key:"onChangeState",value:function(e){this.setState({contact:Object(u.a)(Object(u.a)({},this.state.contact),{},{state:e.target.value})})}},{key:"onChangePostalCode",value:function(e){this.setState({contact:Object(u.a)(Object(u.a)({},this.state.contact),{},{postalCode:e.target.value})})}},{key:"onChangeCountry",value:function(e){this.setState({contact:Object(u.a)(Object(u.a)({},this.state.contact),{},{country:e.target.value})})}},{key:"handleRegister",value:function(e){var t,a,n,r,s,o=this;e.preventDefault(),this.setState({successful:!1}),this.form.validateAll(),0===this.checkBtn.context._errors.length&&this.props.dispatch((t=this.state.username,a=this.state.email,n=this.state.password,r=this.state.phoneNumber,s=this.state.contact,function(e){return U.register(t,a,n,r,s).then((function(t){return e({type:"REGISTER_SUCCESS"}),e({type:"SET_MESSAGE",payload:t.data.message}),Promise.resolve()}),(function(t){var a=t.response&&t.response.data&&t.response.data.message||t.message||t.toString();return e({type:"REGISTER_FAIL"}),e({type:"SET_MESSAGE",payload:a}),Promise.reject()}))})).then((function(){o.setState({successful:!0})})).catch((function(){o.setState({successful:!1})}))}},{key:"render",value:function(){var e=this,t=this.props.message;return r.a.createElement("div",{className:"col-md-12"},r.a.createElement("div",{className:"card card-container"},r.a.createElement("img",{src:"//ssl.gstatic.com/accounts/ui/avatar_2x.png",alt:"profile-img",className:"profile-img-card"}),r.a.createElement(k.a,{onSubmit:this.handleRegister,ref:function(t){e.form=t}},!this.state.successful&&r.a.createElement("div",null,r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"username"},"Username"),r.a.createElement(L.a,{type:"text",className:"form-control",name:"username",value:this.state.username,onChange:this.onChangeUsername,validations:[G,x]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"email"},"Email"),r.a.createElement(L.a,{type:"text",className:"form-control",name:"email",value:this.state.email,onChange:this.onChangeEmail,validations:[G,F]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"password"},"Password"),r.a.createElement(L.a,{type:"password",className:"form-control",name:"password",value:this.state.password,onChange:this.onChangePassword,validations:[G,D]})),r.a.createElement("h5",null,"Contact Details"),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"phoneNumber"},"Phone Number"),r.a.createElement(L.a,{className:"form-control",name:"phoneNumber",value:this.state.phoneNumber,onChange:this.onChangePhoneNumber,validations:[G]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"street"},"Street"),r.a.createElement(L.a,{className:"form-control",name:"street",value:this.state.contact.street,onChange:this.onChangeStreet,validations:[G]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"city"},"City"),r.a.createElement(L.a,{className:"form-control",name:"city",value:this.state.contact.city,onChange:this.onChangeCity,validations:[G]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"state"},"State"),r.a.createElement(L.a,{className:"form-control",name:"state",value:this.state.contact.state,onChange:this.onChangeState,validations:[]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"postalCode"},"Postal Code"),r.a.createElement(L.a,{type:"number",className:"form-control",name:"postalCode",value:this.state.contact.postalCode,onChange:this.onChangePostalCode,validations:[G]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("label",{htmlFor:"country"},"Country"),r.a.createElement(L.a,{className:"form-control",name:"country",value:this.state.contact.country,onChange:this.onChangeCountry,validations:[G]})),r.a.createElement("div",{className:"form-group"},r.a.createElement("button",{className:"btn btn-primary btn-block"},"Sign Up"))),t&&r.a.createElement("div",{className:"form-group"},r.a.createElement("div",{className:this.state.successful?"alert alert-success":"alert alert-danger",role:"alert"},t)),r.a.createElement(P.a,{style:{display:"none"},ref:function(t){e.checkBtn=t}}))))}}]),a}(n.Component);var W=Object(c.b)((function(e){return{message:e.message.message}}))(J);function q(){var e=JSON.parse(localStorage.getItem("user"));return e&&e.accessToken?{Authorization:"Bearer "+e.accessToken}:{}}var z=new(function(){function e(){Object(E.a)(this,e)}return Object(f.a)(e,[{key:"getPublicContent",value:function(){return T.a.get("/api/test/all")}},{key:"getUserBoard",value:function(){return T.a.get("/api/test/user",{headers:q()})}},{key:"getModeratorBoard",value:function(){return T.a.get("/api/test/mod",{headers:q()})}},{key:"getAdminBoard",value:function(){return T.a.get("/api/test/admin",{headers:q()})}}]),e}()),H=function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(e){var n;return Object(E.a)(this,a),(n=t.call(this,e)).state={content:""},n}return Object(f.a)(a,[{key:"componentDidMount",value:function(){var e=this;z.getPublicContent().then((function(t){e.setState({content:t.data})}),(function(t){e.setState({content:t.response&&t.response.data||t.message||t.toString()})}))}},{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("header",{className:"jumbotron"},r.a.createElement("h3",null,this.state.content)))}}]),a}(n.Component),$=function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(){return Object(E.a)(this,a),t.apply(this,arguments)}return Object(f.a)(a,[{key:"render",value:function(){var e=this.props.user;return e?r.a.createElement("div",{className:"container"},r.a.createElement("header",{className:"jumbotron"},r.a.createElement("h3",null,r.a.createElement("strong",null,e.username)," Profile")),r.a.createElement("p",null,r.a.createElement("strong",null,"Token:")," ",e.accessToken.substring(0,20)," ..."," ",e.accessToken.substr(e.accessToken.length-20)),r.a.createElement("p",null,r.a.createElement("strong",null,"Id:")," ",e.id),r.a.createElement("p",null,r.a.createElement("strong",null,"Email:")," ",e.email),r.a.createElement("strong",null,"Authorities:"),r.a.createElement("ul",null,e.roles&&e.roles.map((function(e,t){return r.a.createElement("li",{key:t},e)})))):r.a.createElement(y.a,{to:"/login"})}}]),a}(n.Component);var K=Object(c.b)((function(e){return{user:e.auth.user}}))($),Q=function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(e){var n;return Object(E.a)(this,a),(n=t.call(this,e)).state={content:""},n}return Object(f.a)(a,[{key:"componentDidMount",value:function(){var e=this;z.getUserBoard().then((function(t){e.setState({content:t.data})}),(function(t){e.setState({content:t.response&&t.response.data&&t.response.data.message||t.message||t.toString()})}))}},{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("header",{className:"jumbotron"},r.a.createElement("h3",null,this.state.content)))}}]),a}(n.Component),V=function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(e){var n;return Object(E.a)(this,a),(n=t.call(this,e)).state={content:""},n}return Object(f.a)(a,[{key:"componentDidMount",value:function(){var e=this;z.getModeratorBoard().then((function(t){e.setState({content:t.data})}),(function(t){e.setState({content:t.response&&t.response.data&&t.response.data.message||t.message||t.toString()})}))}},{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("header",{className:"jumbotron"},r.a.createElement("h3",null,this.state.content)))}}]),a}(n.Component),X=function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(e){var n;return Object(E.a)(this,a),(n=t.call(this,e)).state={content:""},n}return Object(f.a)(a,[{key:"componentDidMount",value:function(){var e=this;z.getAdminBoard().then((function(t){e.setState({content:t.data})}),(function(t){e.setState({content:t.response&&t.response.data&&t.response.data.message||t.message||t.toString()})}))}},{key:"render",value:function(){return r.a.createElement("div",{className:"container"},r.a.createElement("header",{className:"jumbotron"},r.a.createElement("h3",null,this.state.content)))}}]),a}(n.Component),Y=a(29),Z=Object(Y.a)(),ee=(a(316),function(e){Object(O.a)(a,e);var t=Object(N.a)(a);function a(e){var n;return Object(E.a)(this,a),(n=t.call(this,e)).logOut=n.logOut.bind(Object(C.a)(n)),n.state={showModeratorBoard:!1,showAdminBoard:!1,currentUser:void 0},Z.listen((function(t){e.dispatch({type:"CLEAR_MESSAGE"})})),n}return Object(f.a)(a,[{key:"componentDidMount",value:function(){var e=this.props.user;e&&this.setState({currentUser:e,showModeratorBoard:e.roles.includes("ROLE_MODERATOR"),showAdminBoard:e.roles.includes("ROLE_ADMIN")})}},{key:"logOut",value:function(){this.props.dispatch((function(e){U.logout(),e({type:"LOGOUT"})}))}},{key:"render",value:function(){var e=this.state,t=e.currentUser,a=e.showModeratorBoard,n=e.showAdminBoard;return r.a.createElement(y.c,{history:Z},r.a.createElement("div",null,r.a.createElement("nav",{className:"navbar navbar-expand navbar-dark bg-dark"},r.a.createElement(S.a,{to:"/",className:"navbar-brand"},"Swapper"),r.a.createElement("div",{className:"navbar-nav mr-auto"},r.a.createElement("li",{className:"nav-item"},r.a.createElement(S.a,{to:"/home",className:"nav-link"},"Home")),a&&r.a.createElement("li",{className:"nav-item"},r.a.createElement(S.a,{to:"/mod",className:"nav-link"},"Moderator Board")),n&&r.a.createElement("li",{className:"nav-item"},r.a.createElement(S.a,{to:"/admin",className:"nav-link"},"Admin Board")),t&&r.a.createElement("li",{className:"nav-item"},r.a.createElement(S.a,{to:"/user",className:"nav-link"},"User"))),t?r.a.createElement("div",{className:"navbar-nav ml-auto"},r.a.createElement("li",{className:"nav-item"},r.a.createElement(S.a,{to:"/profile",className:"nav-link"},t.username)),r.a.createElement("li",{className:"nav-item"},r.a.createElement("a",{href:"/login",className:"nav-link",onClick:this.logOut},"LogOut"))):r.a.createElement("div",{className:"navbar-nav ml-auto"},r.a.createElement("li",{className:"nav-item"},r.a.createElement(S.a,{to:"/login",className:"nav-link"},"Login")),r.a.createElement("li",{className:"nav-item"},r.a.createElement(S.a,{to:"/register",className:"nav-link"},"Sign Up")))),r.a.createElement("div",{className:"container mt-3"},r.a.createElement(y.d,null,r.a.createElement(y.b,{exact:!0,path:["/","/home"],component:H}),r.a.createElement(y.b,{exact:!0,path:"/login",component:_}),r.a.createElement(y.b,{exact:!0,path:"/register",component:W}),r.a.createElement(y.b,{exact:!0,path:"/profile",component:K}),r.a.createElement(y.b,{path:"/user",component:Q}),r.a.createElement(y.b,{path:"/mod",component:V}),r.a.createElement(y.b,{path:"/admin",component:X})))))}}]),a}(n.Component));var te=Object(c.b)((function(e){return{user:e.auth.user}}))(ee);Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));o.a.render(r.a.createElement(c.a,{store:b},r.a.createElement(te,null)),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()})).catch((function(e){console.error(e.message)}))}},[[207,1,2]]]);
//# sourceMappingURL=main.8623e9fb.chunk.js.map