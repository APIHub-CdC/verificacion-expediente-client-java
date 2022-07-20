# Verificación Expediente - Java Client

Verificación de Expediente.<br/><img src='https://github.com/APIHub-CdC/imagenes-cdc/blob/master/circulo_de_credito-apihub.png' height='37' width='160'/></p><br/>

## Requirements

 1. Java 8 or higher
 2. Maven 3 or higher

## Usage

The next command can be used to execute the client:
```shell
mvn compile exec:java
```


## Step by step

> **If you already use the *Círculo de Crédito* APIs and have previously**
> **registered your certificate (public key), skip steps 1 to 3.**

1. You need to get your *Círculo de Crédito* access credentials i.e. **username**, **password** and **api-key**. ([For more information consult the official documentation](https://developer.circulodecredito.com.mx/guia-de-inicio)).

2. Generate a public-private cryptographic key pair using the ECC (Elliptic Curve Cryptography) with the **secp384r1** specification. (The cryptographic key pair is used for the digital signature of the request and response payloads in each HTTP call made to the *Círculo de Crédito* APIs.)

After executing the below commands, two files are generated, one
containing the **private key** (**private-key.pem**) and the other containing the certificate with the **public key** (**certificate.pem**).
> 
> You can change the name of the private key and the certificate files to a
> custom one, just remember that the private key must be the same when
> generating the certificate.

```shell
# Generate private key
openssl ecparam -name secp384r1 -genkey -out private-key.pem
```
```shell
# Generate certificate with public key
openssl req -new -x509 -days 365 \
-key private-key.pem \
-out certificate.pem \
-subj "cdc"
```

3. Register the certificate (public key) generated in the previous step in the [API-Hub portal](https://developer.circulodecredito.com.mx/guia-de-inicio) of *Cículo de Crédito*.

4. Associate the API product ***Validacion de Expediente*** with your application within the *Círculo de Crédito* API Hub portal. ([For more information consult the official documentation](https://developer.circulodecredito.com.mx/guia-de-inicio)).

> This step is very important because if you don't do it you won't be able to
> consume the API.

5. Clone this repository as usual.

```shell
git clone <url>
```
6. Add in the Main class of the code your access credentials provided by *Círculo de Crédito*, as well as the productive URL of the API and the corresponding data to consume the service.

```java
// Path location of the private-key
Path privateKeyFilePath = Path.of("/your-path/your-private-key.pem");

PrivateKeyHelper privateKeyHelper = new EcdsaPrivateKeyHelper(privateKeyFilePath);
SignatureHelper signatureHelper = new EcdsaSignatureHelper(privateKeyHelper);

// Required data for HTTP request
String url = "https://api-url";
String apiKey = "your-x-api-key";
String username = "your-username";
String password = "youer-password";
```

```java
// Create DTO objects
DomicilioFacade domicilio = new DomicilioFacade.Builder()
.direccion("")
.delegacionMunicipio("")
.ciudad("")
.estado(Estado.DISTRITO_FEDERAL)
.codigoPostal("")
.numeroTelefono("")
.build();

PersonaFacade persona = new PersonaFacade.Builder()
.nombre("")
.apellidoPaterno("")
.apellidoMaterno("")
.fechaNacimiento(LocalDate.of(1980, 12, 31))
.rfc("")
.curp("")
.claveElectorIfe("")
.genero(Genero.MASCULINO)
.addDomicilio(domicilio)
.build();

ExpedienteFacade expedienteFacade = new ExpedienteFacade.Builder()
.folio("")
.folioOtorgante("")
.addPersona(persona)
.build();
```

7. Run the code in the console using maven or run it in your favorite IDE. 

```shell
mvn compile exec:java
```

## License
[License & Terms and Conditions](https://github.com/APIHub-CdC/licencias-cdc)
