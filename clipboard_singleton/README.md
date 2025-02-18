# Clipboard Singleton - Documentação

## Introdução

Clipboard, também conhecido como área de transferência, é uma funcionalidade dos sistemas operacionais que permite que programas armazenem e recuperem informações de uma área de armazenamento compartilhada entre diferentes programas.

Popularmente, os programas implementam os atalhos **Ctrl+C** para copiar e **Ctrl+V** para colar.

## Cenário

Imagine um cenário em que um programa de edição de diagramas deseja que, ao copiar um diagrama nele, o conteúdo que será colado dependa do alvo da colagem. 

Por exemplo, um editor de diagramas deseja que você possa:
- **Copiar e colar diagramas no próprio editor.**
- **Colar uma imagem do diagrama copiado ao colar o conteúdo em outro programa.**

## Solução Proposta

Podemos implementar uma classe que funcione da seguinte maneira:

1. **Copiar um diagrama:**
   - O diagrama é armazenado internamente na classe como **XML**.
   - O diagrama é armazenado na área de transferência do sistema operacional como uma imagem.

2. **Colar o conteúdo:**
   - Caso o conteúdo da área de transferência seja uma **imagem**, verificar:
     - Se a imagem corresponde à imagem do diagrama armazenado como **XML** internamente.
     - Se corresponder, colar o **XML** armazenado internamente.

E para que todo o comando compartilhasse essa mesmo clipboard interno, usariamos ela como uma singleton.

Essa abordagem permite um comportamento dinâmico e contexto-sensível para o uso da área de transferência, otimizando a interação entre programas.

## De Para

Seguindo os participantes citados no GOF, o participante Singleton seria a classe DiagramClipBoardSingleton