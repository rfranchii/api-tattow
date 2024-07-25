package com.sqav.tattow.spring.config;

import com.sqav.tattow.support.PropertyManager;

//@Configuration
//@EnableSwagger2
public class SwaggerConfig {

//	@Autowired
//	private PropertyManager propertyManager;
//	private static final String PRODUCAO = "PRODUCAO";
//	@Bean
//	public Docket apiAtendimento() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("atendimento")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para atendimento")
//						.description("API de serviços REST para atendimento.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/atendimento/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiChamada() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("chamada")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para chamada")
//						.description("API de serviços REST para chamada.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/chamada/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiChat() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("chat")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para chat")
//						.description("API de serviços REST para chat.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/chat/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiClinica() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("clinica")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para clinica")
//						.description("API de serviços REST para clinica.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/clinica/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiConvenio() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("convenio")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para convenio")
//						.description("API de serviços REST para convenio.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/convenio/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiDashboard() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("dashboard")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para dashboard")
//						.description("API de serviços REST para dashboard.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/dashboard/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiFinanceiro() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("financeiro")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para financeiro")
//						.description("API de serviços REST para financeiro.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/financeiro/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiMedico() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("medico")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para medico")
//						.description("API de serviços REST para medico.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/medico/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiPaciente() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("paciente")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para paciente")
//						.description("API de serviços REST para paciente.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/paciente/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}
//	
//	@Bean
//	public Docket apiUsuario() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("usuario")
//				.apiInfo(baseApiInfo()
//						.title("API de serviços REST para usuario")
//						.description("API de serviços REST para usuario.")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/usuario/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(false));
//		//@formatter:on
//	}
	
//	@Bean
//	public Docket apiIntegrationEnterprise() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("integration-enterprise")
//				.apiInfo(baseApiInfo()
//						.title("API Rest para Integração com Empresas")
//						.description("Serviços utilizados por empresas e prontuários para integração.")
//						.version("1.0")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/integration/enterprise/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSecretToken(false));
//		//@formatter:on
//	}
//	@Bean
//	public Docket apiCommandCenter() throws Exception {
//		if (propertyManager.getEnvironmentProperty("AMBIENTE").equals("PRODUCAO")) {
//			return null;
//		}
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("Novo Admin")
//				.apiInfo(baseApiInfo()
//						.title("API Rest Admin")
//						.description("Serviços utilizados pela nova plataforma admin.")
//						.version("1.0")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("br.com.conexasaude.commandcenter"))
//				.paths(manyPaths())
//				.build()
//				.globalOperationParameters(parametrosHeaderSecretToken(false));
//		//@formatter:on
//	}


//	private Predicate<String> manyPaths() throws Exception {
//		return or(
//			regex("/appointment.*"),
//			regex("/appointment-queue.*"),
//			regex("/dashboard.*"),
//			regex("/permission.*"),
//			regex("/user.*"),
//			regex("/admin.*"),
//			regex("/account.*"),
//			regex("/clinic.*")
//		);
//	}

//	@Bean
//	public Docket apiIntegrationAppPaciente() {
//		//@formatter:off
//		return new Docket(DocumentationType.SWAGGER_2)
//				.groupName("integration-app-paciente")
//				.apiInfo(baseApiInfo()
//						.title("API Rest para Integração para o App do Paciente")
//						.description("Serviços utilizados pelo App do Paciente para integração.")
//						.version("1.0")
//						.build())
//				.select()
//				.apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.regex("/integration/app-paciente/.*"))
//				.build()
//				.globalOperationParameters(parametrosHeaderSomenteToken(true));
//		//@formatter:on
//	}		
	
	/*
	@Bean
	public Docket apiIntegrationAppSegundaOpiniao() {
		//@formatter:off
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("integration-app-segundaopiniao")
				.apiInfo(baseApiInfo()
						.title("API Rest para Integração para o App de Segunda Opinião Médica")
						.description("Serviços utilizados pelo App de Segunda Opinião Médica.")
						.version("1.0")
						.build())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.regex("/integration/app-segundaopiniao/.*"))
				.build()
				.globalOperationParameters(parametrosHeaderSomenteToken(true));
		//@formatter:on
	}*/	

//	private ApiInfoBuilder baseApiInfo() {
//		//@formatter:off
//		return new ApiInfoBuilder()
//				.termsOfServiceUrl("http://www.conexasaude.com.br")
//				.contact(new Contact("Conexa Saúde", "http://www.conexasaude.com.br", "daniel.vieira@conexasaude.com.br"))
//				.version("1.0");
//		//@formatter:on
//	}
//
//	private List<Parameter> parametrosHeaderSecretToken(boolean required) {
//		//@formatter:off
//		return Lists.newArrayList(new ParameterBuilder()
//				.name("token")
//				.description("Secret TOKEN provided")
//				.modelRef(new ModelRef("string"))
//				.parameterType("header")
//				.required(required)
//			.build());
//		// @formatter:on
//	}
//
//	private List<Parameter> parametrosHeaderSomenteToken(boolean required) {
//		//@formatter:off
//		return Lists.newArrayList(new ParameterBuilder()
//				.name("token")
//				.description("Token gerado no login")
//				.modelRef(new ModelRef("string"))
//				.parameterType("header")
//				.required(required)
//				.build());
//		//@formatter:on
//	}

}
