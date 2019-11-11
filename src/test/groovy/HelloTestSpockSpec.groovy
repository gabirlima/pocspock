import groovyx.net.http.HttpResponseDecorator
import groovyx.net.http.RESTClient
import models.Planets
import spock.lang.Shared
import spock.lang.Specification

class HelloTestSpockSpec extends Specification {

    @Shared
    private RESTClient client = new RESTClient("https://swapi.co/api/planets/1/", "application/json")

    def "Testar GET"(){
        when:
            HttpResponseDecorator response = client.get([:])
            Planets planet = response.responseData
        then:
            response.status == 200
            planet.name.equals("Tatooine")
            print(response.responseData)

    }
}
